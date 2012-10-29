package com.briup.service;

import com.briup.bean.Member;

public interface IMemberService {

	void save(Member m);
	
	void update(Member m);
	
	boolean delete(long id) throws Exception;
	
}
