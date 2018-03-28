package com.niit.chat.chatterboxback.dao;

import java.util.List;

import com.niit.chat.chatterboxback.model.ApplyJob;
import com.niit.chat.chatterboxback.model.Job;

public interface JobDao {
	
	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> jobList();
	public Job getJob(int jobId);
	public boolean applyJob(ApplyJob applyJob);
	public List<ApplyJob> getAllAppliedJobDetails();
}
