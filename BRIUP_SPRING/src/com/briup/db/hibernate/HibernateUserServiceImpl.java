package com.briup.db.hibernate;

import com.briup.db.bean.User;
import com.briup.db.dao.IUserDao;
import com.briup.db.service.IUserService;

public class HibernateUserServiceImpl implements IUserService {
	private IUserDao dao;

	public IUserDao getDao() {
		return dao;
	}

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(User user) throws Exception {
		user.setId(10);
		dao.save(user);
		int a = 0;
		//事务是加在service层的
		if(a == 0){
			throw new Exception("我是故意的！");
		}
		user.setId(11);
		dao.save(user);

	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub

	}

}
