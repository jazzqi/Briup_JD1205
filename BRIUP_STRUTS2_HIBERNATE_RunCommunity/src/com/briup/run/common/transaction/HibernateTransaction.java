package com.briup.run.common.transaction;

import org.hibernate.Session;

import com.briup.run.common.util.HibernateSessionFactory;

public class HibernateTransaction implements Transaction {
	private org.hibernate.Transaction transaction;

	@Override
	public void beginTransaction() {
		Session session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
	}

	@Override
	public void commit() {
		transaction.commit();
	}

	@Override
	public void rollback() {
		transaction.rollback();
	}
	
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}
