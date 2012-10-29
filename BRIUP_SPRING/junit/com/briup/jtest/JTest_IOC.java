package com.briup.jtest;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.Member;
import com.briup.bean.Teacher;
import com.briup.test.BeanFactory;

public class JTest_IOC {
	
	@Test
	public void test(){
		//System.out.println("hello junit");
		//Teacher t = new Teacher();
		Teacher t = (Teacher) BeanFactory.getBean("t");
		
		System.out.println(t);
		System.out.println(t.getStudent());
	}
	
	//使用Spring的set方式注入
	@Test
	public void ioc_set(){
		//path中可以存储多个路径信息
		String[] path = {"/com/briup/ioc/set/set.xml"};
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		Teacher teacher = (Teacher) container.getBean("teacher");
		Teacher teacher2 = (Teacher) container.getBean("teacher");
		//System.out.println(""+teacher+teacher2);
		System.out.println(teacher.getStudent().getAddress());
		System.out.println(teacher.getId());
		System.out.println(teacher.getName());
	}
	
	//使用Spring的Constructor方式注入
	@Test
	public void ioc_constructor(){
		String[] path = {"/com/briup/ioc/constructor/constructor.xml"};
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		Teacher teacher = (Teacher) container.getBean("teacher");
		Teacher teacher2 = (Teacher) container.getBean("teacher");
		//System.out.println(""+teacher+teacher2);
		System.out.println(teacher.getStudent().getAddress());
		System.out.println(teacher.getId());
		System.out.println(teacher.getName());
	}

	//使用Spring的Collection方式注入
	@Test
	public void ioc_collection(){
		String[] path = {"/com/briup/ioc/collection/collection.xml"};
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		Teacher t = (Teacher) container.getBean("teacher");
		t.getStudent().getAddress().showCollection();
	}
	
	//测试Spring中bean的生命周期
	@Test
	public void ioc_lifeCycle(){
		String[] path = {"/com/briup/ioc/lifeCycle/lifeCycle.xml"};
		//init method，单例模式时会在读取xml文件后直接生成bean对象，调用init方法
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		//使用容器的destroy方法时会调用destory method，仅限单例模式
		container.destroy();
	}
	
	//Spring自动装载
	@Test
	public void ioc_autowire(){
		String[] path = {"/com/briup/ioc/autoweired/autowired.xml"};
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		Teacher t = (Teacher) container.getBean("teacher");
		System.out.println(t.getStudent().getName());
	}

	//Spring实现工厂类生成对象并注入, 方法一
	@Test
	public void ioc_factory(){
		try {
			String[] path = {"/com/briup/ioc/factory/factory.xml"};
			ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
			Connection conn = (Connection) container.getBean("conn");
			System.out.println(conn);
			if(null != conn){
				conn.close();
			}
		} catch (BeansException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Spring实现工厂类生成对象并注入，方法二
	@Test
	public void ioc_instance_factory(){
		try {
			String[] path = {"/com/briup/ioc/instanceFactory/instanceFactory.xml"};
			ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
			Connection conn = (Connection) container.getBean("conn");
			System.out.println(conn);
			if(null != conn){
				conn.close();
			}
		} catch (BeansException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Spring实现工厂类生成对象并注入，方法三
	@Test
	public void ioc_static_factory(){
		try {
			String[] path = {"/com/briup/ioc/staticFactory/staticFactory.xml"};
			ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
			Connection conn = (Connection) container.getBean("conn");
			System.out.println(conn);
			if(null != conn){
				conn.close();
			}
		} catch (BeansException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void ioc_annotation_autowired(){
		try {
			String[] path = {"/com/briup/ioc/annotation/annotation-autowired.xml"};
			ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
			Member m = (Member) container.getBean("member");
			System.out.println(m.getOrder().getId());
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void ioc_annotation_resource(){
		try {
			String[] path = {"/com/briup/ioc/annotation/annotation-resource.xml"};
			ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
			Member m = (Member) container.getBean("member");
			System.out.println(m.getOrder().getId());
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
