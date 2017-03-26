package com.benjsicam.restfulblog.client;

import com.benjsicam.restfulblog.domain.Author;
import com.benjsicam.restfulblog.domain.Post;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="post",configuration = FeingClientConfiguration.class)
public interface PostClientService {

    @RequestMapping(method = RequestMethod.GET, value="/resources/posts/{postId}")
    Post findPostById(@PathVariable("postId") Long authorId);
}
