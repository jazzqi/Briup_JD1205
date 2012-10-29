package com.briup.jtest;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.db.bean.User;
import com.briup.db.hibernate.HibernateUserServiceImpl;
import com.briup.db.service.IUserService;

public class JTest_DB {
	
	@Test
	public void jdbc_test() throws Exception{
		String path[] = {"com/briup/db/dataSource.xml",
				"com/briup/db/jdbc/jdbc_dao.xml",
				"com/briup/db/jdbc/jdbc_service.xml"};
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		IUserService service = (IUserService) container.getBean("service");
		User u = new User(1,"tt",23);
		service.save(u);
		service.delete(1l);
	}

	@Test
	public void jdbcTemplate_test() throws Exception{
		String path[] = {"com/briup/db/dataSource.xml",
				"com/briup/db/jdbcTemplate/JdbcTemplate_dao.xml",
				"com/briup/db/jdbcTemplate/JdbcTemplate_service.xml"};
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		IUserService service = (IUserService) container.getBean("service");
		User u = new User(1,"tt",23);
		service.save(u);
	}
	
	@Test
	public void hibernate_test() throws Exception{
		String path[] = {"com/briup/db/dataSource.xml",
				"com/briup/db/hibernate/Hibernate_service.xml",
				"com/briup/db/hibernate/Hibernate_dao.xml"};
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		IUserService service = (IUserService) container.getBean("serviceProxy");
		User u = new User(2,"tt",23);
		service.save(u);
	}
	
	@Test
	public void hibernateTemplate_test() throws Exception{
		String path[] = {"com/briup/db/dataSource.xml",
				"com/briup/db/hibernateTemplate/HibernateTemplate_service.xml",
				"com/briup/db/hibernateTemplate/HibernateTemplate_dao.xml"};
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		IUserService service = (IUserService) container.getBean("service");
		User u = new User(4,"ht",23);
		service.save(u);
	}
}
