package com.briup.bbs.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.briup.bbs.dao.MemberDao;
import com.briup.bbs.pojo.Member;

public class MemberDaoImpl implements MemberDao {
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Member findMemberByName(String name) {
		// TODO Auto-generated method stub
		try {
			if (null!=session
					.createQuery("from Member m where m.name=?")
					.setString(0, name).list().get(0)) {
				return (Member)(session
					.createQuery("from Member m where m.name=?")
					.setString(0, name).list().get(0)) ;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean saveOrUpdate(Member member) {
		// TODO Auto-generated method stub
		try {
			session.saveOrUpdate(member);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
