package com.mygroup.daoimpl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mygroup.dao.UserDetailsDAO;
import com.mygroup.model.UserDetails1;


@Repository("userDetailsDAO")
@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDetailsDAOImpl(){}
	
	public UserDetailsDAOImpl(SessionFactory sf){
		this.sessionFactory=sf;
	}
	
	public List<UserDetails1> getUsers() {
		
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("from UserDetails1 order by isonline desc");
		List <UserDetails1> data = qr.list();
		ses.close();
		return data;
		
	}
	
	public UserDetails1 getUserById(String uid){
		return (UserDetails1)sessionFactory.openSession().get(UserDetails1.class, uid);
	}
	
	public void deleteUser(String uid){
		Session ses = sessionFactory.openSession();
		Transaction tr = ses.beginTransaction();
		UserDetails1 ud = (UserDetails1)ses.get(UserDetails1.class, uid);
		ses.delete(ud);
		tr.commit();
		ses.close();
	}
	
	public  void addUser(UserDetails1 ud){
		Session ses = sessionFactory.openSession();
		Transaction tr = ses.beginTransaction();
		ud.setUserid(generateUserId());
		ud.setRole("ROLE_USER");
		ud.setEnabled(true);
		ses.save(ud);
		tr.commit();
		ses.close();
	}
	
	@Transactional
	public UserDetails1 updateUser(String uid,UserDetails1 ud){
		Session ses = sessionFactory.openSession();
		UserDetails1 presud = (UserDetails1)ses.get(UserDetails1.class, uid);
		if(presud==null)
			return null;
		
		//ud = (UserDetails)ses.get(UserDetails.class, ud.getUserid());
		presud=ud;
		//ses.update(presud);
		ses.flush();
		ses.close();
		return ud;
		
	}
		
	@Transactional
	private String generateUserId(){		
	String newUid="";
		Session ss = sessionFactory.openSession();
		Transaction t=ss.beginTransaction();
		
		Query qq = ss.createQuery("from UserDetails1");
		if(qq.list().isEmpty())
		{
			newUid="USR00001";
		}
		else{	
			Query q = ss.createQuery("select max(userid) from UserDetails1");			
			String prevId = q.list().get(0).toString();
			//String prevId = data.get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);
			id=id+1;
			if(id<=9)
				newUid="USR0000"+id;
			else if(id<=99)
				newUid="USR000"+id;
			else if(id<=999)
				newUid="USR00"+id;
			else if(id<=9999)
				newUid="USR0"+id;
			else
				newUid="USR"+id;		
			System.out.print("\nGenerated : "+newUid);
			t.commit();				
		}
		ss.close();	
		return newUid;
	}

	@Transactional
	private String generateUserProfileId(){		
	String newUid="";
		Session ss = sessionFactory.openSession();
		Transaction t=ss.beginTransaction();
		
		Query qq = ss.createQuery("from UserProfile1");
		if(qq.list().isEmpty())
		{
			newUid="USP00001";
		}
		else{	
			Query q = ss.createQuery("select max(userid) from UserProfile1");			
			String prevId = q.list().get(0).toString();
			//String prevId = data.get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);
			id=id+1;
			if(id<=9)
				newUid="USP0000"+id;
			else if(id<=99)
				newUid="USP000"+id;
			else if(id<=999)
				newUid="USP00"+id;
			else if(id<=9999)
				newUid="USP0"+id;
			else
				newUid="USP"+id;		
			System.out.print("\nGenerated : "+newUid);
			t.commit();				
		}
		ss.close();	
		return newUid;
	}
	
	@Transactional
	public UserDetails1 logincheck(UserDetails1 ud) {
		logger.debug("UserDAOImpl : logincheck()");
		Session ses = sessionFactory.openSession();
		Query qry = ses.createQuery("from UserDetails1 where userid=? and password=?");
		qry.setString(0, ud.getUserid());
		qry.setString(1, ud.getPassword());
		UserDetails1 validuser = (UserDetails1)qry.uniqueResult();
		//logger.debug("Valid user : " + validuser.getRole());
		ses.close();
		return validuser;
		
	}

	@Transactional
	public UserDetails1 registerUser(UserDetails1 ud){
		Session ses = sessionFactory.openSession();
		Transaction tr = ses.beginTransaction();
		ud.setUserid(generateUserId());
		ses.save(ud);
		tr.commit();
		ses.close();
		return ud;
	}
	
	@Transactional
	public  UserDetails1 updateUser1(UserDetails1 ud){
		Session ses = sessionFactory.openSession();
		Transaction tr = ses.beginTransaction();
		ses.update(ud);
		tr.commit();
		ses.close();	
		return ud;
	}
	
	public boolean saveImage(){
		
	/*	System.out.print("\nimg : " + ud.getImageFile());	
			
		try{				    	
			if (ud.getImageFile() != null ) {
	           	Path path=Paths.get("C://DT5-SEC-Workspace//FreshProj-win8//buytoys//src//main//webapp//resources//images//users//"+ud.getUserid()+".jpg");	
	           	ud.getImageFile().transferTo(new File(path.toString()));                       	
	            System.out.println("User Image Saved");	            
	        }		
			
		}
		catch(Exception ex){
			System.out.print("\nUnable to delete record...");
		}		*/
		return true;
	}

}
