package com.mygroup.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mygroup.dao.FileDAO;
import com.mygroup.model.UploadFile1;



@Repository
public class FileDAOImpl implements FileDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void uploadFile(UploadFile1 file) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save(file);
		session.flush();
		session.close();
	}

	
	public UploadFile1 getFile(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UploadFile1 where userid=?");
		query.setParameter(0, username);
		UploadFile1 uploadFile=(UploadFile1)query.uniqueResult();
		return uploadFile;
	}

}













