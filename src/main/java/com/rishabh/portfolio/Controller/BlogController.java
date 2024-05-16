package com.rishabh.portfolio.Controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.portfolio.Domain.Blogs;
import com.rishabh.portfolio.Service.BlogService;


@RestController
@RequestMapping("/blog/post")
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@GetMapping("/")
	public ArrayList<Blogs> posts() throws InterruptedException, ExecutionException {
		return blogService.getAllBlogs();
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<Blogs> postById(@PathVariable String postId) throws InterruptedException, ExecutionException {
		Blogs blog=blogService.getBlogById(postId);
		
		return ResponseEntity.ok().body(blog);
	}

}
