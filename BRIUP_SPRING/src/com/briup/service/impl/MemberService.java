package com.briup.service.impl;

import com.briup.bean.Member;
import com.briup.dao.IMemberDao;
import com.briup.service.IMemberService;

public class MemberService implements IMemberService {
	
	private IMemberDao dao;

	@Override
	public void save(Member m) {
		dao.save(m);

	}

	@Override
	public void update(Member m) {
		dao.update(m);
	}

	@Override
	public boolean delete(long id) throws Exception {
		if(id == 1l){
			throw new Exception("测试异常信息");
		}
		return dao.delete(id);
	}

	public IMemberDao getDao() {
		return dao;
	}

	public void setDao(IMemberDao dao) {
		this.dao = dao;
	}
	

}
