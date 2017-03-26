package com.benjsicam.restfulblog.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "post_category")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="post_id")
    private Long postId;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id",referencedColumnName = "id")
    private Category category;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
