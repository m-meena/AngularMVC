package com.niit.chat.chatterboxmid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.chat.chatterboxback.dao.BlogDao;
import com.niit.chat.chatterboxback.model.Blog;

@RestController
public class BlogController {

	@Autowired
	BlogDao blogDao;
	
	/*@GetMapping(value="/demo")
	public ResponseEntity<String> demoPurpose()
	{
		return new ResponseEntity<String>("demo data",HttpStatus.OK);
	}*/
	
	@PostMapping(value = "/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog)
	{
		blog.setCreationDate(new java.util.Date());
		blog.setLikes(0);
		blog.setUserName("Meena");
		blog.setStatus("A");
		
		if(blogDao.addBlog(blog))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/listBlog")
	public ResponseEntity<List<Blog>> getListBlog()
	{
		List<Blog> listBlog = blogDao.blogList("Meena");
		if(listBlog.size() > 0)
		{
			return new ResponseEntity<List<Blog>>(listBlog,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Blog>>(listBlog,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog(@PathVariable("blogId") int blogId)
	{
		Blog blog = blogDao.getBlog(blogId);
		if(blogDao.deleteBlog(blog))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/incrementLikes/{blogId}")
	public ResponseEntity<String> incrementLikes(@PathVariable("blogId") int blogId)
	{
		Blog blog = blogDao.getBlog(blogId);
		if(blogDao.incrementLike(blog))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
}
