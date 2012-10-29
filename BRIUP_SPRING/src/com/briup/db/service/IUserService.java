package com.briup.db.service;

import com.briup.db.bean.User;

public interface IUserService {

	void save(User user) throws Exception;
	
	void delete(long id) throws Exception;
	
}
