package com.briup.db.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.briup.db.bean.User;
import com.briup.db.dao.IUserDao;

public class HibernateUserDaoImpl implements IUserDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(User user) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);

	}

}
