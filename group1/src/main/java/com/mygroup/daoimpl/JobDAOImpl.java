package com.mygroup.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mygroup.dao.JobDAO;
import com.mygroup.model.Job1;


@Repository
public class JobDAOImpl implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public void postJob(Job1 job) {
		Session ses = sessionFactory.openSession();
		Transaction tr = ses.beginTransaction();
		job.setJobid(generateJobId());
		ses.save(job);		
		tr.commit();
		ses.flush();
		ses.close();
	}

	@Transactional
	public List<Job1> getAllJobs() {
		Session ses = sessionFactory.openSession();
		Transaction tr = ses.beginTransaction();
		Query qr = ses.createQuery("from Job1");
		List <Job1> data = qr.list();
		tr.commit();
		ses.flush();
		ses.close();		
		return data;
	}
	
	@Transactional
	private String generateJobId(){		
	String newJid="";
		Session ss = sessionFactory.openSession();
		Transaction t=ss.beginTransaction();
		
		Query qq = ss.createQuery("from Job1");
		if(qq.list().isEmpty())
		{
			newJid="JOB00001";
		}
		else{	
			Query q = ss.createQuery("select max(jobid) from Job1");			
			String prevId = q.list().get(0).toString();
			//String prevId = data.get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);
			id=id+1;
			if(id<=9)
				newJid="JOB0000"+id;
			else if(id<=99)
				newJid="JOB000"+id;
			else if(id<=999)
				newJid="JOB00"+id;
			else if(id<=9999)
				newJid="JOB0"+id;
			else
				newJid="JOB"+id;		
			System.out.print("\nGenerated : "+newJid);
			t.commit();				
		}
		ss.close();	
		return newJid;
	}
}
