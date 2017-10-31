package com.mygroup.dao;

import com.mygroup.model.UploadFile1;

public interface FileDAO {

	public abstract void uploadFile(UploadFile1 file);
	
	public abstract UploadFile1 getFile(String username);
}
