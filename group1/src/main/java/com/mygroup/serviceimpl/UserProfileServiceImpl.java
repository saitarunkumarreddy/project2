package com.mygroup.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygroup.dao.UserProfileDAO;
import com.mygroup.model.UserProfile1;
import com.mygroup.service.UserProfileService;


@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileDAO userProfileDao;
	
	public List<UserProfile1> getProfiles() {		
		return userProfileDao.getProfiles();
	}

}
