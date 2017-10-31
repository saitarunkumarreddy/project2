package com.mygroup.dao;

import java.util.List;

import com.mygroup.model.Blog1;



public interface BlogDAO {
	public void createBlog(Blog1 b);
	public List<Blog1> getBlogList();
	public void deleteBlog(Blog1 b);	
	public Blog1 getCompleteBlog(String bid);
}
