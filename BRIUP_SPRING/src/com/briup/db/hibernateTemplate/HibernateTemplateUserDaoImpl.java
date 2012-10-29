package com.briup.db.hibernateTemplate;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.briup.db.bean.User;
import com.briup.db.dao.IUserDao;

public class HibernateTemplateUserDaoImpl implements IUserDao{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(User user) throws Exception {
		hibernateTemplate.save(user);
	}

}
