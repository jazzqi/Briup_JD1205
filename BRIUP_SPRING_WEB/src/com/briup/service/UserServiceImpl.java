package com.briup.service;

import com.briup.bean.User;
import com.briup.dao.IUserDao;

public class UserServiceImpl implements IUserService{
	private IUserDao dao;

	public IUserDao getDao() {
		return dao;
	}

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	public void register(User user) throws Exception {
		dao.save(user);
	}

}
