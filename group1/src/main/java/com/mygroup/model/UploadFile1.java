package com.mygroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class UploadFile1 {

	@Id
	@GeneratedValue
	@Column(name="FILE_ID")	
	private int id;
	
	@Column(name="FILE_NAME")
	private String filename;
	
	@Lob
	@Column(name="FILE_DATA")
	private byte[] data;
	
	private String userid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
	

}
