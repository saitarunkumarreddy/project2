package com.mygroup.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {

	@Id
	private String testid;
	private String testname;
	public String getTestid() {
		return testid;
	}
	public void setTestid(String testid) {
		this.testid = testid;
	}
	public String getTestname() {
		return testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}	
}