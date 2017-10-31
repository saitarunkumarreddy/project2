package com.mygroup.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mygroup.dao.FileDAO;
import com.mygroup.model.UserDetails1;
import com.mygroup.model.Error;
import com.mygroup.model.UploadFile1;
import com.mygroup.service.UserDetailsService;
import com.mygroup.serviceimpl.EmailService;



@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private FileDAO fileUploadDao;
	
	@RequestMapping(value="/logincheck", method=RequestMethod.POST)
	public ResponseEntity <?> logincheck(@RequestBody UserDetails1 userdetails,HttpSession session){
		logger.debug("Entering UserController : Login()");
		String userid=userdetails.getUserid();
		UserDetails1 validuser = userDetailsService.logincheck(userdetails);
		logger.debug("\n" + userdetails.getUserid());
		
		if(validuser==null){
			logger.debug("validuser is null");
			Error error = new Error(1,"User does not exists");
			return new ResponseEntity<Error> (error,HttpStatus.UNAUTHORIZED);// 401
		}
		else{
			session.setAttribute("user", validuser);
			validuser.setIsonline(true);
			userDetailsService.updateUser1(validuser); // - to be uncommented after 
			System.out.print("\nlogincheck - " + validuser.getRole()); 
			logger.debug("valid user is available");
			
			 //select * from proj2_profile_pics where username='adam';
			  UploadFile1 getUploadFile=fileUploadDao.getFile(validuser.getUserid());
			  if(getUploadFile!=null){
		  	//String name=getUploadFile.getFilename();
		  	System.out.println(getUploadFile.getData());
		  	byte[] imagefiles=getUploadFile.getData();
		  	try{
		  		//C:\DTv3-Wave2-Som-Oxygen\group1\src\main\webapp\resources
		  		String path="E:/workspace1996/group1/src/main/webapp/resources/images/users/"+validuser.getUserid()+".jpg";
		  		File file=new File(path);
		  		//file.mkdirs();
		  		FileOutputStream fos = new FileOutputStream(file);//to Write some data 
		  		fos.write(imagefiles);
		  		fos.close();
		  		}catch(Exception e){
		  		e.printStackTrace();
		  		}
			  }
			
			
			return new  ResponseEntity<UserDetails1> (validuser, HttpStatus.OK);
		}		
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody UserDetails1 userdetails) throws MessagingException{
		logger.debug("UserController : register(): " + userdetails.getUserid());
		userdetails.setEnabled(true);
		userdetails.setIsonline(false);
		userdetails.setRole("ROLE_USER");
		
		UserDetails1 newUser = userDetailsService.registerUser(userdetails);
		if(newUser==null){
			logger.debug("User is not registerd");
			Error error = new Error(2,"Could not insert user details");
			return new ResponseEntity<Error> (error,HttpStatus.CONFLICT);// 
		}
		else{
			logger.debug("User id is generated");
			String username = newUser.getFullname();
			String subject="Registration Success";
			
			String body= "Dear " + username +",\nWelcome to BuyToys.com";
			body = body + "\n\nYou have been registered with us!! thank you\nYour user id : "+newUser.getUserid()+"\nUse this user id to login to our website";
			body = body + "\n\n\nRegards,\nBuyToys Team\nDT5 - Secunderabad";
			//emailService.send(newUser, subject, body);
		
			return new  ResponseEntity<UserDetails1> (newUser,HttpStatus.OK);
		}	
		
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.PUT)
	public ResponseEntity<?> logout(HttpSession session){
		UserDetails1 ud = (UserDetails1)session.getAttribute("user");
		if(ud!=null){
			ud.setIsonline(false);
			userDetailsService.updateUser1(ud);
			try{
                //change according to your workspace path and project name
				String path="E:/workspace1996/group1/src/main/webapp/resources/images/users/"+ud.getUserid()+".jpg";
				File file=new File(path);
				System.out.println(file.delete());
		
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		session.removeAttribute("user");		
		session.invalidate();
		return new  ResponseEntity<Void> (HttpStatus.OK);		
		
	}
	
	
	@RequestMapping(value="/userUpdate",method=RequestMethod.PUT)
	public ResponseEntity<?> userUpdate1(@RequestBody UserDetails1 userdetails,HttpSession session){
		userdetails.setIsonline(true);
		
		return new  ResponseEntity<Void> (HttpStatus.OK);		
		
	}

	@RequestMapping(value="/getUserDetails",method=RequestMethod.GET)
	public ResponseEntity<?> getUserDetails(HttpSession session){
		UserDetails1 ud = (UserDetails1)session.getAttribute("user");
		if(ud!=null){
			List <UserDetails1> data = userDetailsService.getUsers();
			return new ResponseEntity<List<UserDetails1>> (data,HttpStatus.OK);// 401
		}
		else{
			Error error = new Error(1,"Login required before displaying user details");
			return new ResponseEntity<Error> (error,HttpStatus.UNAUTHORIZED);// 401
		}	
		
	}
	

}
