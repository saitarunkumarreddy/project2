package com.mygroup.controller;

import java.util.Date;
import java.util.List;

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

import com.mygroup.dao.JobDAO;
import com.mygroup.model.Job1;
import com.mygroup.model.UserDetails1;
import com.mygroup.model.Error;



@RestController
public class JobController {
	
	@Autowired
	private JobDAO jobDao;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// user should login before doing the below
	@RequestMapping(value="/reqpostjob", method=RequestMethod.POST)
	public ResponseEntity<?> postJob(@RequestBody Job1 job, HttpSession session){
		logger.debug("backend controller..");
		UserDetails1 currentuser = (UserDetails1)session.getAttribute("user");
		logger.debug("backend controller..after user..");
		if(currentuser==null){
			Error er = new Error(1,"Unauthorized user...login before posting job");
			return new ResponseEntity<Error> (er,HttpStatus.UNAUTHORIZED);		// 401	
			// RETURND RESPONSE OBJ - DATA [ERROR]
			// FRONT END - response.data.message
		}
		else {
			String role = currentuser.getRole();
			if(role.equals("ROLE_ADMIN")){
				job.setAvailable(true);
				job.setPosteddate(new Date());
				jobDao.postJob(job);
				return new ResponseEntity<Void> (HttpStatus.OK);
			}
			else{
				Error error = new Error(2,"Only ADMIN can post new jobs...");
				return new ResponseEntity<Error> (error,HttpStatus.UNAUTHORIZED); // 401
			}
		}		
	}
	
	@RequestMapping(value="/getalljobs",method=RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(HttpSession session){
		UserDetails1 ud = (UserDetails1)session.getAttribute("user");
		if(ud==null){
			Error er =new Error(1,"UnAutorized user");
			return new ResponseEntity<Error> (er,HttpStatus.UNAUTHORIZED);
		}
		else{
			List <Job1> jobs = jobDao.getAllJobs();
			return new ResponseEntity<List<Job1>> (jobs,HttpStatus.OK);
		}		
	}

}
