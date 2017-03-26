package com.benjsicam.restfulblog.dao;

import com.benjsicam.restfulblog.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query
	Category findByName(String name);

	@Query("SELECT category FROM Category category JOIN FETCH category.postCategories pc WHERE pc.postId=?1")
	List<Category> findCategoriesByPostId(Long id);


}
