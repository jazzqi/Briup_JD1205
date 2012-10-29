package com.briup.db.dao;

import com.briup.db.bean.User;

public interface IUserDao {
	
	void delete(long id) throws Exception;
	
	void save(User user) throws Exception;

}
