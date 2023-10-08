package com.infybuzz.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.infybuzz.request.CommentRequest;
import com.infybuzz.request.PostRequest;
import com.infybuzz.response.CommentReponse;



@FeignClient(url = "${post.service.url}", value = "post-feign-client",
		path = "/")
public interface PostFeignClient {

	@GetMapping("/posts/{id}")
	public String getById(@PathVariable long id);
	
	@GetMapping("/posts")
	public String getPosts();
	
	@GetMapping("/posts/{userId}")
	public String getByUserId(@PathVariable("userId") long id);
	
	@PostMapping("/posts")
	public String createPost(@RequestBody PostRequest request);
	
	@PostMapping("/comments")
	public String createComment(@RequestBody CommentRequest request);
	
	
}
