package com.niit.chat.chatterboxback.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chat.chatterboxback.dao.UserDao;
import com.niit.chat.chatterboxback.model.User;

@Repository("userDao")
@Transactional
public class UserImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Override
	public User getUser(int userId) {
		return sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> userList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();		
		List<User> list=session.createQuery("from UserTable").list();
		session.getTransaction().commit();
		session.close();		
		return list;
	}

}
