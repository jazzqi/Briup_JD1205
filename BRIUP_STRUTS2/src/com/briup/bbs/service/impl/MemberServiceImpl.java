package com.briup.bbs.service.impl;

import org.hibernate.Session;

import com.briup.bbs.dao.impl.MemberDaoImpl;
import com.briup.bbs.pojo.Member;
import com.briup.bbs.service.MemberService;
import com.briup.bbs.util.HibernateSessionFactory;

public class MemberServiceImpl implements MemberService {

	private final MemberDaoImpl memberDao = new MemberDaoImpl();

	@Override
	public boolean saveOrUpdate(Member member) {
		Session session = HibernateSessionFactory.getSession();
		memberDao.setSession(session);
		try {
			session.beginTransaction();
			memberDao.saveOrUpdate(member);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public Member findMemberByName(String name) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		memberDao.setSession(session);
		Member member = null;
		try {
			session.beginTransaction();
			member = memberDao.findMemberByName(name);
			session.getTransaction().commit();
			return member;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Member findMemberByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		memberDao.setSession(session);
		Member member = null;
		try {
			session.beginTransaction();
			member = memberDao.findMemberByEmail(email);
			session.getTransaction().commit();
			return member;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
