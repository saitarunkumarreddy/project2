package com.mygroup.dao;

import java.util.List;

import com.mygroup.model.UserDetails1;


public interface UserDetailsDAO {
	public abstract List<UserDetails1> getUsers();
	public abstract UserDetails1 getUserById(String uid);
	public abstract void addUser(UserDetails1 ud);
	
	public abstract UserDetails1 updateUser(String uid,UserDetails1 ud);
	
	public abstract void deleteUser(String uid);
	
	public abstract UserDetails1 logincheck(UserDetails1 ud);
	
	public abstract UserDetails1 registerUser(UserDetails1 ud);
	
	public abstract UserDetails1 updateUser1(UserDetails1 ud);
	
	public abstract boolean saveImage();
	
}
