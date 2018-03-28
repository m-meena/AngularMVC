package com.niit.chat.chatterboxback.model;

import java.util.Date;

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
	private String jobCompany;
	private int jobSalary;
	private String jobLocation;
	private String jobDesc;
	private Date lastDateApply;
	
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
	public String getJobCompany() {
		return jobCompany;
	}
	public void setJobCompany(String jobCompany) {
		this.jobCompany = jobCompany;
	}
	public int getJobSalary() {
		return jobSalary;
	}
	public void setJobSalary(int jobSalary) {
		this.jobSalary = jobSalary;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public Date getLastDateApply() {
		return lastDateApply;
	}
	public void setLastDateApply(Date lastDateApply) {
		this.lastDateApply = lastDateApply;
	}
	
	
}
