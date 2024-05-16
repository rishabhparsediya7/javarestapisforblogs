package com.rishabh.portfolio.Controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.portfolio.Domain.Blogs;
import com.rishabh.portfolio.Service.BlogService;

@RestController
@RequestMapping("/blog/admin")
public class AdminController {
	
	@Autowired
	BlogService blogService;
	
	@GetMapping("/")
	public String home(){
		
		return "home page";
		
	}
	
	@PostMapping("/create")
	public String create(@RequestBody Blogs blog) throws InterruptedException, ExecutionException{	
		
		return blogService.save(blog);
	
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		
		return blogService.deleteById(id);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Blogs blog) throws InterruptedException, ExecutionException {
		return blogService.updateById(blog);
	}
	
}
