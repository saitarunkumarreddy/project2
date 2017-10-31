package com.mygroup.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygroup.dao.UserDetailsDAO;
import com.mygroup.model.UserDetails1;
import com.mygroup.service.UserDetailsService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDAO userDetailsDao;
	
	public UserDetailsServiceImpl(){}
	
	public UserDetailsServiceImpl(UserDetailsDAO ud){
		this.userDetailsDao=ud;
	}
	public List<UserDetails1> getUsers() {
		return userDetailsDao.getUsers();		 
	}
	public UserDetails1 getUserById(String uid){
		return userDetailsDao.getUserById(uid);
	}
	public void addUser(UserDetails1 ud){
		userDetailsDao.addUser(ud);
	}
	public UserDetails1 updateUser(String uid,UserDetails1 ud){
		return userDetailsDao.updateUser(uid,ud);
	}

	public void deleteUser(String uid){
		userDetailsDao.deleteUser(uid);
	}
	
	public UserDetails1 logincheck(UserDetails1 ud){
		return userDetailsDao.logincheck(ud);
	}
	public UserDetails1 registerUser(UserDetails1 ud){
		return userDetailsDao.registerUser(ud);
	}
	
	public void updateUser1(UserDetails1 ud){
		userDetailsDao.updateUser1(ud);
	}
}
