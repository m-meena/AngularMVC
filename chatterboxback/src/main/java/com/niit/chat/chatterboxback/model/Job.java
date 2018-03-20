package com.niit.chat.chatterboxback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="JobTable")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobId;
	
	private String jobDesignation;
	private int jobSalary;
	private String jobDescription;
	private String jobLocation;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobDesignation() {
		return jobDesignation;
	}
	public void setJobDesignation(String jobDesignation) {
		this.jobDesignation = jobDesignation;
	}
	public int getJobSalary() {
		return jobSalary;
	}
	public void setJobSalary(int jobSalary) {
		this.jobSalary = jobSalary;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	
}
