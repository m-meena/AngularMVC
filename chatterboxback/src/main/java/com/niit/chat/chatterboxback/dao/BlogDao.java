package com.niit.chat.chatterboxback.dao;

import java.util.List;

import com.niit.chat.chatterboxback.model.Blog;

public interface BlogDao {

	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> blogList(String userName);
	public boolean incrementLike(Blog blog);
}
