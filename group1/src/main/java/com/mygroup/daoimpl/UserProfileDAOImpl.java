package com.mygroup.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mygroup.dao.UserProfileDAO;
import com.mygroup.model.UserProfile1;


@Repository
public class UserProfileDAOImpl implements UserProfileDAO {
	@Autowired
	private SessionFactory sessionFactory;	
	
	public List<UserProfile1> getProfiles() {
		
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("from UserProfile1");
		List <UserProfile1> data = qr.list();
		ses.close();
		return data;
		
	}
}
