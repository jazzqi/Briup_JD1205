package com.briup.db.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

import com.briup.db.bean.User;
import com.briup.db.dao.IUserDao;

public class JdbcUserDaoImpl implements IUserDao {
	
	private DataSource dataSource;
	
	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = dataSource.getConnection();
		
		System.out.println(conn);
		if(null != conn){
			conn.close();
		}

	}

	@Override
	public void save(User user) throws Exception {
		// TODO Auto-generated method stub

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
