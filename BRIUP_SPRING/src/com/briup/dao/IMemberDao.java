package com.briup.dao;

import com.briup.bean.Member;

public interface IMemberDao {

	void save(Member m);
	
	void update(Member m);
	
	boolean delete(long id);
	
}
