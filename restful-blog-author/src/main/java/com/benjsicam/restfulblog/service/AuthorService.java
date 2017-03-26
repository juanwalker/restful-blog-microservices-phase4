package com.benjsicam.restfulblog.service;


import com.benjsicam.restfulblog.client.PostClientService;
import com.benjsicam.restfulblog.dao.AuthorRepository;
import com.benjsicam.restfulblog.domain.Author;
import com.benjsicam.restfulblog.domain.Credentials;
import com.benjsicam.restfulblog.domain.Post;
import com.benjsicam.restfulblog.domain.RabbitMQMessage;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
	private final static String queueName = "restful-blog-credentials";
	private final static String exchangeName = "restful-blog-credentials-exchange";
	private static final Log logger = LogFactory.getLog(AuthorService.class);
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private PostClientService postsClientService;

	@Autowired
	private AuthorRepository authorRepository;


	@Transactional
	public void create(Author author) throws IOException {
		author.setPassword(passwordEncoder.encode(author.getPassword()));
		authorRepository.saveAndFlush(author);
		Credentials authorCredentails = this.createAuthorCredentails(author);
		this.sendRabbitMQMessage("create",authorCredentails);
		logger.info("you called create");
	}

	@Transactional
	public void update(Author author) throws IOException {
		if (this.findById(author.getId())!= null){
			author.setPassword(passwordEncoder.encode(author.getPassword()));
			authorRepository.saveAndFlush(author);
			Credentials authorCredentails = this.createAuthorCredentails(author);
			this.sendRabbitMQMessage("update",authorCredentails);
		}
		logger.info("you called update");
	}

	@Transactional
	public void delete(Long id) throws IOException {
		authorRepository.delete(id);
		this.sendRabbitMQMessage("delete",id);
		logger.info("you called delete");
	}

	@HystrixCommand(fallbackMethod = "getDefaultAuthors")
	public List<Author> find() {
		logger.info("you called find");
		return authorRepository.findAll();
	}

	public List<Author> getDefaultAuthors(){
		logger.info("getDefaultAuthors called");
		return new ArrayList<Author>();
	}

	@HystrixCommand(fallbackMethod = "findByIdDefault")
	public Author findById(Long id) {
		logger.info("you called findById ");
		return authorRepository.findOne(id);
	}

	public Author findByIdDefault(){
		logger.info("getDefaultAuthors called");
		return new Author();
	}

	@HystrixCommand(fallbackMethod = "getDefaultPosts")
	public List<Post> findAuthorPosts(Long authorId ) {
		logger.info("you called findAuthorPosts");
		return postsClientService.findByAuthor(authorId);
	}

	public List<Post> getDefaultPosts(Long authorId){
		logger.info("called getDefaultPosts");
		return new ArrayList<Post>();
	}



	@HystrixCommand(fallbackMethod = "getDefaultAuthorUsername")
	public Author findByUsername(String userName) {
		logger.info("you called findByUsername");
		return authorRepository.findByUsername(userName);
	}

	public Author getDefaultAuthorUsername(String userName){
		logger.info(" called getDefaultAuthorUsername");
		return new Author();
	}

	
	@Transactional
	public void updatePassword(Author author) throws IOException {
		logger.info("you called updatePassword");
		author.setPassword(passwordEncoder.encode(author.getPassword()));
		Credentials authorCredentails = this.createAuthorCredentails(author);
		this.sendRabbitMQMessage("update",authorCredentails);
	}


	private Credentials createAuthorCredentails(Author author){
		Credentials credentials = new Credentials();
		credentials.setId(author.getId());
		credentials.setUsername(author.getUsername());
		credentials.setPassword(author.getPassword());
		return credentials;
	}


	private void sendRabbitMQMessage(String operation,Object body) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		RabbitMQMessage message = new RabbitMQMessage("author",operation,mapper.writeValueAsString(body));
		rabbitTemplate.setExchange(exchangeName);
		rabbitTemplate.setMessageConverter(getJsonMessageConverter());
		this.rabbitTemplate.convertAndSend(message);
	}

	public MessageConverter getJsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
