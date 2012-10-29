package com.briup.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.briup.bean.User;

public class UserDaoImpl implements IUserDao{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(User user) throws Exception {
		hibernateTemplate.save(user);
	}

}
