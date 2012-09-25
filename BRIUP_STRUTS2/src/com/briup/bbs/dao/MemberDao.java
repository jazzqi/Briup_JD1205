package com.briup.bbs.dao;

import com.briup.bbs.pojo.Member;

public interface MemberDao {
	public boolean saveOrUpdate(Member member);
	public Member findMemberByName(String name);
	public Member findMemberByEmail(String email);
}
