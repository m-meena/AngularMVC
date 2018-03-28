package com.niit.chat.chatterboxback.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chat.chatterboxback.dao.BlogDao;
import com.niit.chat.chatterboxback.model.Blog;

public class BlogTest {

	static Blog blog;
	static BlogDao blogDao;
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.chat.chatterboxback");
		context.refresh();
		blogDao = (BlogDao) context.getBean("blogDao");
	}
	
	@Test
	public void addBlogTest()
	{
		blog = new Blog();
		blog.setBlogName("chatter");
		blog.setBlogContent("welcome");
		blog.setCreationDate(new Date());
		blog.setStatus("enable");
		blog.setUserName("aathi");
		assertEquals("Added", true, blogDao.addBlog(blog));
	}
	
	@Test
	public void updateBlogTest()
	{
		blog = blogDao.getBlog(1);
		blog.setBlogName("communication");		
		assertEquals("Updated", true, blogDao.updateBlog(blog));
	}
	
	@Test
	public void deleteBlogTest()
	{
		blog = blogDao.getBlog(1);
		assertEquals("Deleted", true, blogDao.deleteBlog(blog));
	}
	
	@Test
	public void listBlogTest()
	{
		assertEquals("Display list", 1, blogDao.blogList("aathi").size());
	}
}
