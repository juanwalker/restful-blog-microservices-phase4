package com.benjsicam.restfulblog.service;

import com.benjsicam.restfulblog.client.PostClientService;
import com.benjsicam.restfulblog.dao.CategoryRepository;
import com.benjsicam.restfulblog.domain.Category;
import com.benjsicam.restfulblog.domain.Post;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

	private static final Log logger = LogFactory.getLog(CategoryService.class);

	@Autowired
	PostClientService postClient;

	@Autowired
	CategoryRepository categoryRepository;

	@Transactional
	public void create(Category category) {		
		categoryRepository.saveAndFlush(category);
		logger.info("you called create");
	}
	
	@Transactional
	public void update(Category category) {		
		categoryRepository.saveAndFlush(category);
		logger.info("you called update");
	}
	
	@Transactional
	public void delete(Long id) {
		categoryRepository.delete(id);
		logger.info("you called delete");
	}

	@HystrixCommand(fallbackMethod = "findDefault")
	public List<Category> find() {
		logger.info("you called findDefault");
		return categoryRepository.findAll();
	}

	private List<Category> findDefault(){
		logger.info("called findDefault");
		return new ArrayList<Category>();
	}

	@HystrixCommand(fallbackMethod = "findByIdDefault")
	public Category findById(Long id) {
		logger.info("you called findByIdDefault");
		return categoryRepository.findOne(id);
	}



	private Category findByIdDefault(Long id){
		logger.info("called findByIdDefault");
		return new Category();
	}

	@HystrixCommand(fallbackMethod = "getDefaultFindCategoryPosts")
	public List<Category> findCategoriesByPostId(Long id) {
		logger.info("you called findCategoriesByPostId");
		return categoryRepository.findCategoriesByPostId(id);
	}

	private List<Category> getDefaultFindCategoryPosts(Long id){
		logger.info("called getDefaultFindCategoryPosts");
		return new ArrayList<Category>();
	}

	@HystrixCommand(fallbackMethod = "findPostDefault")
	public Post findPost(Long id) {
		logger.info("you called findPost");
		return postClient.findPostById(id);
	}

	private Post findPostDefault(Long id){
		logger.info("called findPostDefault");
		return new Post();
	}
}
