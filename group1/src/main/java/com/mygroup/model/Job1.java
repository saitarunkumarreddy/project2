package com.mygroup.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Job1 {
	@Id
	private String jobid;
	private String jobtitle;
	private String jobdesc;
	private Date posteddate;
	private String qualification;
	private String skillreq;
	private int salary;
	private String location;
	private String companyurl;
	private boolean isAvailable;
	
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getJobdesc() {
		return jobdesc;
	}
	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}
	public Date getPosteddate() {
		return posteddate;
	}
	public void setPosteddate(Date posteddate) {
		this.posteddate = posteddate;
	}
	public String getSkillreq() {
		return skillreq;
	}
	public void setSkillreq(String skillreq) {
		this.skillreq = skillreq;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getCompanyurl() {
		return companyurl;
	}
	public void setCompanyurl(String companyurl) {
		this.companyurl = companyurl;
	}
	
	
}
