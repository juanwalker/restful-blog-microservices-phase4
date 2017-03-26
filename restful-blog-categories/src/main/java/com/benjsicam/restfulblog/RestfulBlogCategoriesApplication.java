package com.benjsicam.restfulblog;

import com.benjsicam.restfulblog.domain.Category;
import com.benjsicam.restfulblog.domain.Post;
import com.benjsicam.restfulblog.domain.PostCategory;
import com.benjsicam.restfulblog.rabbitmq.RabbitMQClient;
import com.benjsicam.restfulblog.service.CategoryService;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@ComponentScan
@RequestMapping("/resources/categories")
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class RestfulBlogCategoriesApplication {

	private static final Log logger = LogFactory.getLog(RestfulBlogCategoriesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestfulBlogCategoriesApplication.class, args);
	}

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void create(@RequestBody Category entity) {
		logger.info("create called");
		categoryService.create(entity);
	}
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Category entity) {
		logger.info("update called");
		categoryService.update(entity);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		logger.info("delete called");
		categoryService.delete(id);
	}
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Category> find() {
		logger.info("find called");
		return categoryService.find();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Category findCategory(@PathVariable("id") Long id ) {
		logger.info("findCategory called");
		return categoryService.findById(id);
	}
	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
	public @ResponseBody List<Post> findCategoryPosts(@PathVariable("id") Long id ) {
		List<Post> posts = new ArrayList<Post>();
		Category category = categoryService.findCategoriesByPostId(id).get(0);
		category.getPostCategories().size();
		for (PostCategory pc: category.getPostCategories()){
			posts.add(categoryService.findPost(pc.getPostId()));
		}
		logger.info("findCategoryPosts called");
		return posts;
	}
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Category> findCategoriesByPostId(@PathVariable("id") Long id ) {
		logger.info("findCategoriesByPostId called");
		return categoryService.findCategoriesByPostId(id);
	}
}
