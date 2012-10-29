package com.briup.db.hibernateTemplate;

import com.briup.db.bean.User;
import com.briup.db.dao.IUserDao;
import com.briup.db.service.IUserService;

public class HibernateTemplateUserServiceImpl implements IUserService{
	private IUserDao dao;

	public IUserDao getDao() {
		return dao;
	}

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(User user) throws Exception {
		// TODO Auto-generated method stub
		dao.save(user);
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
