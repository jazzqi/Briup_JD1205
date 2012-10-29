package com.briup.jtest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.service.IMemberService;
import com.briup.test.aop.BookService;
import com.briup.test.aop.IBookService;
import com.briup.test.aop.LogTest;

public class JTest_AOP {

	//手动模拟aop实现日志记录
	@Test
	public void test(){
		final IBookService service = new BookService();
		LogTest log = new LogTest();
		
		Class clazz = service.getClass();
		

		InvocationHandler myHandler = new InvocationHandler() {
			private Object target = service;
			private LogTest log = new LogTest();
			
			//第一个参数是代理对象本身
			//第二个参数是需要被代理的方法的镜像
			//第三个参数是调用方法时的参数列表
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				//不能使用proxy，不然会产生死循环，但是可以使用getClass()等final方法
				//System.out.println(proxy);
				//AOP
				//日志输出
				log.log(method.getName()+" is invoked..");
				//调用实际方法
				return method.invoke(target, args);
			}
			public Object getTarget() {
				return target;
			}
			public void setTarget(Object target) {
				this.target = target;
			}
		};
			
		//第一个参数：目标对象的类加载器
		//第二个参数：目标对象实现的所有接口
		//第三个参数：InvocationHandler接口的实现类对象
		IBookService proxy = (IBookService) Proxy.newProxyInstance(
				clazz.getClassLoader(), clazz.getInterfaces(), myHandler);

		proxy.save();
		proxy.update();
		proxy.delete();
		
		System.out.println(proxy + ":" + proxy.getClass());
		System.out.println(service + ":" + service.getClass());
		System.out.println(proxy == service);
		
	}
	
	
	@Test
	public void aop_before(){
		String path[] = {"com/briup/aop/before/before.xml","com/briup/dao/impl/dao.xml"};
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		IMemberService  service = (IMemberService) container.getBean("proxy");
		service.save(null);
	}
	
	@Test
	public void aop_after() throws Exception{
		String path[] = {"com/briup/aop/after/after.xml"};
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		IMemberService service = (IMemberService) container.getBean("proxy");
		//service.save(null);
		service.delete(1l);
		//service.update(null);
	}
	
	@Test 
	public void aop_arround() throws Exception{
		String path = "com/briup/aop/arround/arround.xml";
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		IMemberService service = (IMemberService) container.getBean("proxy");
		service.save(null);
		service.delete(0l);
		service.update(null);
	}
	
	@Test
	public void aop_throwing() throws Exception{
		String path="com/briup/aop/throwing/throwing.xml";
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		IMemberService service = (IMemberService) container.getBean("proxy");
		service.delete(1l);
	}
	
	@Test
	public void aop_advisor() throws Exception{
		String path="com/briup/aop/advisor/advisor.xml";
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		IMemberService service = (IMemberService) container.getBean("proxy");
		service.delete(0l);
		service.save(null);
		service.update(null);
	}
	
	//自动代理对象，直接使用target的名字来获得相应的proxy对象
	@Test
	public void aop_autoproxy() throws Exception{
		String path="com/briup/aop/autoproxy/autoproxy.xml";
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		IMemberService service = (IMemberService) container.getBean("target2");
		System.out.println(service.getClass());
		service.save(null);
		service.update(null);
	}
	
	//自动代理对象，
	@Test
	public void aop_autoproxybyname() throws Exception{
		String path="com/briup/aop/autoproxybyname/autoproxybyname.xml";
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
		IMemberService service = (IMemberService) container.getBean("target1");
		System.out.println(service.getClass());
		service.save(null);
	}
}
