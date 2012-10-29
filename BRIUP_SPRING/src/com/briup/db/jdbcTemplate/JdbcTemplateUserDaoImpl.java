package com.briup.db.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import com.briup.db.bean.User;
import com.briup.db.dao.IUserDao;

public class JdbcTemplateUserDaoImpl implements IUserDao{
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(User user) throws Exception {
		// TODO Auto-generated method stub
		long id = user.getId();
		String name = user.getName();
		int age = user.getAge();
		String sql = "insert into spring_t_user(id,name,age) values("+id+",'"+name+"',"+age+")";
		jdbcTemplate.execute(sql);
	}

}
