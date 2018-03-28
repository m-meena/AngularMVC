package com.niit.chat.chatterboxback.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chat.chatterboxback.dao.JobDao;
import com.niit.chat.chatterboxback.model.ApplyJob;
import com.niit.chat.chatterboxback.model.Job;

@Repository("jobDao")
@Transactional
public class JobImpl implements JobDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateJob(Job job) {
		sessionFactory.getCurrentSession().update(job);
		return true;
	}

	@Override
	public boolean deleteJob(Job job) {
		sessionFactory.getCurrentSession().delete(job);
		return true;
	}

	@Override
	public Job getJob(int jobId) {
		return sessionFactory.getCurrentSession().get(Job.class, jobId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Job> jobList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();		
		List<Job> list=session.createQuery("from JobTable").list();
		session.getTransaction().commit();
		session.close();		
		return list;
	}

	@Override
	public boolean applyJob(ApplyJob applyJob) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ApplyJob> getAllAppliedJobDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
