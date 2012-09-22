package com.briup.bbs.test;

import com.briup.bbs.pojo.Member;
import com.briup.bbs.service.MemberService;
import com.briup.bbs.service.impl.MemberServiceImpl;


public class TestHibernate {
	public static void main(String[] args) {
		MemberService memberService=new MemberServiceImpl();
		Member member=memberService.findMemberByName("a");
		System.out.println(member.getEmail());
		/*
		Session session=HibernateSessionFactory.getSession();
		Session session2=new Configuration().configure().buildSessionFactory().openSession();
		
		System.out.println(session);
		//Transaction transaction=session.beginTransaction();
		//List<Topic> topics=session.createQuery("from Topic").list();
		List<Topic> topics=session2.createQuery("from Topic").list();
		//transaction.commit();
		for (Topic topic : topics) {
			System.out.println(topic.getName());
		}
		*/
	}

}
