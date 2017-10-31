package com.mygroup.dao;

import java.util.List;

import com.mygroup.model.Job1;


public interface JobDAO {

	public abstract void postJob(Job1 job);
	public abstract List<Job1> getAllJobs();
}
