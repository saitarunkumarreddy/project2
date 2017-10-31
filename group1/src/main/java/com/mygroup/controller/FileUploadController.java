package com.mygroup.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mygroup.dao.FileDAO;
import com.mygroup.model.UploadFile1;
import com.mygroup.model.UserDetails1;



@RestController
public class FileUploadController {

	@Autowired
	private FileDAO fileUploadDao;	
	
	 @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	    public void handleFileUpload(HttpServletRequest request,HttpSession session, @RequestParam("fileUpload") MultipartFile fileUpload) throws Exception {
	         UserDetails1 user=(UserDetails1)session.getAttribute("user");
	         if(user==null)
	        	 throw new RuntimeException("Not logged in");
	         System.out.println("USER is " + user.getUserid());
	         
	         if (fileUpload != null ) {
	             CommonsMultipartFile aFile = (CommonsMultipartFile)fileUpload;
	            
	                System.out.println("Saving file: " + aFile.getOriginalFilename());
	                
	                UploadFile1 uploadFile = new UploadFile1();
	                uploadFile.setFilename(aFile.getOriginalFilename());
	                uploadFile.setData(aFile.getBytes());//image 
	                uploadFile.setUserid(user.getUserid());//login details
	                fileUploadDao.uploadFile(uploadFile);
	                //select * from proj2_profie_pics where username='smith'
	                UploadFile1 getUploadFile=fileUploadDao.getFile(user.getUserid());
	            	String name=getUploadFile.getFilename();
	            	System.out.println(getUploadFile.getData());
	            	byte[] imagefiles=getUploadFile.getData();  //image
	            	try{
	            		//change the path according to your workspace and the name of your project
	            		//C:\WORKSPACE-DT5\toygroup1\src\main\webapp\WEB-INF\resources\images
	            		String path="E:/workspace1996/group1/src/main/webapp/resources/images/users/"+user.getUserid()+".jpg";
	            		File file=new File(path);
	            		//file.mkdirs();
	            		FileOutputStream fos = new FileOutputStream(file);
	            		fos.write(imagefiles);// write the array of bytes in username file.
	            		fos.close();
	            		}catch(Exception e){
	            		e.printStackTrace();
	            		}
	             }
	                
	 
	        //return "redirect:/#/displayUsers";
	    }
	
	
}
