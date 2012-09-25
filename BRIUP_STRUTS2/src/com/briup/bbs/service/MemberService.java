package com.briup.bbs.service;

import com.briup.bbs.pojo.Member;

public interface MemberService {
	public boolean saveOrUpdate(Member member);

	public Member findMemberByName(String name);
	
	public Member findMemberByEmail(String email);
}
