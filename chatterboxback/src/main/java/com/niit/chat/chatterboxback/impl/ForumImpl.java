package com.niit.chat.chatterboxback.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chat.chatterboxback.dao.ForumDao;
import com.niit.chat.chatterboxback.model.Forum;

@Repository("forumDao")
@Transactional
public class ForumImpl implements ForumDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public boolean updateForum(Forum forum) {
		sessionFactory.getCurrentSession().update(forum);
		return true;
	}

	@Override
	public boolean deleteForum(Forum forum) {
		sessionFactory.getCurrentSession().delete(forum);
		return true;
	}

	@Override
	public boolean approveForum(Forum forum) {
		forum.setStatus("Enable");
		sessionFactory.getCurrentSession().update(forum);
		return true;
	}

	@Override
	public boolean rejectForum(Forum forum) {
		forum.setStatus("NA");
		sessionFactory.getCurrentSession().update(forum);
		return true;
	}

	@Override
	public Forum getForum(int forumId) {
		return sessionFactory.getCurrentSession().get(Forum.class, forumId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Forum> forumList(String userName) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();		
		List<Forum> list=session.createQuery("from ForumTable").list();
		session.getTransaction().commit();
		session.close();		
		return list;
	}

}
