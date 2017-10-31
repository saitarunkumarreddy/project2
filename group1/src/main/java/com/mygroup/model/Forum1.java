package com.mygroup.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Forum1 {
	
	@Id
	private String forumID;
	private String forumTitle;
	private String forumCategory;
	private String forumContent;
	private String forumCreatedUser;
	private Date forumCreationDate;
	private String forumStatus;
	
	public String getForumID() {
		return forumID;
	}
	public void setForumID(String forumID) {
		this.forumID = forumID;
	}
	public String getForumTitle() {
		return forumTitle;
	}
	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}
	public String getForumCategory() {
		return forumCategory;
	}
	public void setForumCategory(String forumCategory) {
		this.forumCategory = forumCategory;
	}
	public String getForumContent() {
		return forumContent;
	}
	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}
	public String getForumCreatedUser() {
		return forumCreatedUser;
	}
	public void setForumCreatedUser(String forumCreatedUser) {
		this.forumCreatedUser = forumCreatedUser;
	}
	public Date getForumCreationDate() {
		return forumCreationDate;
	}
	public void setForumCreationDate(Date forumCreationDate) {
		this.forumCreationDate = forumCreationDate;
	}
	public String getForumStatus() {
		return forumStatus;
	}
	public void setForumStatus(String forumStatus) {
		this.forumStatus = forumStatus;
	}
	
	

}
