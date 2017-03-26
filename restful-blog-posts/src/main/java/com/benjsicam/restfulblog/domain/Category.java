package com.benjsicam.restfulblog.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

	private Long id;

	private String name;

	private Set<PostCategory> postCategories;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Set<PostCategory> getPostCategories() {
		if (postCategories == null){
			postCategories = new HashSet<>();
		}
		return postCategories;
	}

	public void setPostCategories(Set<PostCategory> postCategories) {
		this.postCategories = postCategories;
	}
}
