package com.benjsicam.restfulblog.service;


import com.benjsicam.restfulblog.client.AuthorClientService;
import com.benjsicam.restfulblog.client.CategoryClientService;
import com.benjsicam.restfulblog.dao.PostRepository;
import com.benjsicam.restfulblog.domain.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

	private static final Log logger = LogFactory.getLog(PostService.class);
	final static String queueName = "restful-blog-category";
	final static String exchangeName = "restful-blog-category-exchange";

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private AuthorClientService authorClientService;

	@Autowired
	private CategoryClientService categoryClientService;

	@Transactional
	public void create(Post post) throws IOException {
		postRepository.saveAndFlush(post);
		for (Category category :post.getCategories()){
			PostCategory postCategory = new PostCategory();
			postCategory.setPostId(post.getId());
			category.getPostCategories().add(postCategory);

		}
		this.sendRabbitMQMessage("create",post.getCategories());
		logger.info("you called create");
	}
	@Transactional
	public void update(Post post) throws IOException {
		postRepository.saveAndFlush(post);
		this.sendRabbitMQMessage("update",post.getCategories());
		logger.info("you called update");
	}
	private void sendRabbitMQMessage(String operation,Object body) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		RabbitMQMessage message = new RabbitMQMessage("post",operation,mapper.writeValueAsString(body));
		rabbitTemplate.setExchange(exchangeName);
		rabbitTemplate.convertAndSend(queueName,message);
		rabbitTemplate.setMessageConverter(getJsonMessageConverter());
	}
	public MessageConverter getJsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	@Transactional
	public void delete(Long id) {
		postRepository.delete(id);
		logger.info("you called delete");
	}
	@HystrixCommand(fallbackMethod = "findDefault")
	public List<Post> find() {
		logger.info("you called findAll");
		return postRepository.findAll();
	}
	public List<Post> findDefault(){
		logger.info(" called findDefault");
		return new ArrayList<Post>();
	}
	@HystrixCommand(fallbackMethod = "findByIdDefault")
	public Post findById(Long id ) {
		logger.info("you called findAll");
		return postRepository.findOne(id);
	}
	public Post findByIdDefault(Long id){
		logger.info(" called findDefault");
		return new Post();
	}
	@HystrixCommand(fallbackMethod = "findPostAuthorDefault")
	public Long findPostAuthor(Long id) {
		logger.info("you called findPostAuthor");
		return postRepository.findPostAuthor(id);
	}
	public Long findPostAuthorDefault(Long id){
		logger.info(" called findPostAuthorDefault");
		return new Long(0);
	}
	@HystrixCommand(fallbackMethod = "findByAuthorDefault")
	public List<Post> findByAuthor(@PathVariable("authorId") Long authorId) {
		logger.info("you called findByAuthor");
		return postRepository.findByAuthor(authorId);
	}
	public List<Post> findByAuthorDefault(Long id){
		logger.info(" called findByAuthorDefault");
		return new ArrayList<Post>();
	}
	@HystrixCommand(fallbackMethod = "findByUserIdDefault")
	public Author findByUserId(Long postAuthorId) {
		logger.info("you called findByUserId");
		return authorClientService.findByUserId(postAuthorId);
	}
	public Author findByUserIdDefault(Long id){
		logger.info(" called findByUserIdDefault");
		return new Author();
	}
	@HystrixCommand(fallbackMethod = "findPostCategoriesDefault")
	public List<Category> findPostCategories(Long id) {
		logger.info("you called findPostCategories");
		return categoryClientService.findCategoriesByPostId(id);
	}
	public List<Category> findPostCategoriesDefault(Long id){
		logger.info(" called findByUserIdDefault");
		return new ArrayList<Category>();
	}
}
