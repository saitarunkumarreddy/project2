package com.mygroup.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Blog1 {
	@Id	
	private String blogID;
	private String blogTitle;
	private String blogContent;
	private String blogCreatedUser;
	private Date blogCreationDate;
	private String blogStatus;
	public String getBlogID() {
		return blogID;
	}
	public void setBlogID(String blogID) {
		this.blogID = blogID;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public String getBlogCreatedUser() {
		return blogCreatedUser;
	}
	public void setBlogCreatedUser(String blogCreatedUser) {
		this.blogCreatedUser = blogCreatedUser;
	}
	public Date getBlogCreationDate() {
		return blogCreationDate;
	}
	public void setBlogCreationDate(Date blogCreationDate) {
		this.blogCreationDate = blogCreationDate;
	}
	public String getBlogStatus() {
		return blogStatus;
	}
	public void setBlogStatus(String blogStatus) {
		this.blogStatus = blogStatus;
	}
	
}
