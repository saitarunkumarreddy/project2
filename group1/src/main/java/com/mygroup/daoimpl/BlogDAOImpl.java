package com.mygroup.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mygroup.dao.BlogDAO;
import com.mygroup.model.Blog1;




@Repository
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;   
	
	public BlogDAOImpl(){}
	
	public BlogDAOImpl(SessionFactory sf){
		this.sessionFactory=sf;
	}

	@Transactional
	public void createBlog(Blog1 b) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		System.out.println("Blog dao impl" +  b);
		b.setBlogID(generateBlogId());
	//	User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	//	String username=user.getUsername();
	//	b.setBlogCreatedUser(username);
	//	Date dt = new Date();
		//String date = dt.getYear()+"-"+dt.getMonth()+"-"+dt.getDate();	
	//	System.out.println(dt);
	//	b.setBlogCreationDate(dt);
	//	b.setBlogStatus("valid");		
		s.save(b);
		t.commit();	
		s.close();
	}

	
	public List<Blog1> getBlogList() {
		// TODO Auto-generated method stub
		List<Blog1> lst;
		System.out.println("getAllBlogs()");
		Session ses = sessionFactory.openSession();
		System.out.println("getBlogList()session " + ses.isOpen());
		Query qry = ses.createQuery("from Blog1 where blogStatus='active'");
		lst = qry.list();
		System.out.println(lst);
		ses.close();
		return lst;		
		
	}

	
	public void deleteBlog(Blog1 b) {
		// TODO Auto-generated method stub

	}

	
	public Blog1 getCompleteBlog(String bid) {
		// TODO Auto-generated method stub
		Blog1 b;	
		List<Blog1> lst;
		System.out.println("DAO-getCompleteBlog()");
		Session ses = sessionFactory.openSession();
		System.out.println("getBlogList()session " + ses.isOpen());
		Query qry = ses.createQuery("from Blog1 where blogid="+bid);
		lst = qry.list();
		b=lst.get(0);
		System.out.println(lst);
		ses.close();
		return b;		
	}
	
	@Transactional
	private String generateBlogId(){
		
		String newBid="";
		Session ss = sessionFactory.openSession();			
		Transaction t=ss.beginTransaction();
		
		Query qq = ss.createQuery("from Blog1");
		if(qq.list().isEmpty())	{
			newBid="BLOG00001";
		}
		else{	
			Query q = ss.createQuery("select max(blogID) from Blog1");			
			String prevId = q.list().get(0).toString();
			//String prevId = data.get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(4));
			System.out.print("\nExisting id : "+id);
			id=id+1;
			if(id<=9)
				newBid="BLOG0000"+id;
			else if(id<=99)
				newBid="BLOG000"+id;
			else if(id<=999)
				newBid="BLOG00"+id;
			else if(id<=9999)
				newBid="BLOG0"+id;
			else
				newBid="BLOG"+id;		
			System.out.print("\nGenerated : "+newBid);
			t.commit();			
		}
		ss.close();	
		return newBid;
	}

}
