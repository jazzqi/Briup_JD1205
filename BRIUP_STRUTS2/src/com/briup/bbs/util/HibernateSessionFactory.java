package com.briup.bbs.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	public static SessionFactory sessionFactory;
	static{
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("*************Build SessionFactory Error*************");
		}
	}

	public static Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
