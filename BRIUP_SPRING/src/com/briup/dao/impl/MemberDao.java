package com.briup.dao.impl;

import com.briup.bean.Member;
import com.briup.dao.IMemberDao;

public class MemberDao implements IMemberDao {

	
	@Override
	public void save(Member m) {
		System.out.println("save successful");
	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		System.out.println("update successful");

	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		System.out.println("delete successful");
		return true;
	}

}
