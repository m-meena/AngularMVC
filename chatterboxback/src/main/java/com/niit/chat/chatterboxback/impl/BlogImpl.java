package com.niit.chat.chatterboxback.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chat.chatterboxback.dao.BlogDao;
import com.niit.chat.chatterboxback.model.Blog;

@Repository("blogDao")
@Transactional
public class BlogImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addBlog(Blog blog) {
		System.out.println("going to add blog");
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}		
	}

	@Override
	public boolean updateBlog(Blog blog) {
		
		System.out.println("going to update blog");
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		sessionFactory.getCurrentSession().delete(blog);
		return true;
	}

	public boolean approveBlog(Blog blog) {
		blog.setStatus("A");
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}

	public boolean rejectBlog(Blog blog) {
		blog.setStatus("R");
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}

	@Override
	public Blog getBlog(int blogId) {
		return sessionFactory.getCurrentSession().get(Blog.class, blogId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Blog> blogList(String userName) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();		
		List<Blog> list=session.createQuery("from BlogTable where userName = '" +userName+ "'" ).list();
		session.getTransaction().commit();
		session.close();		
		return list;
	}

	@Override
	public boolean incrementLike(Blog blog) {
		sessionFactory.getCurrentSession().update(blog);
		return false;
	}

}
