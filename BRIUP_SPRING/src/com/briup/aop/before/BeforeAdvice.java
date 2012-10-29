package com.briup.aop.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.briup.log.Logger;

public class BeforeAdvice implements MethodBeforeAdvice{
	private Logger log;

	//第一个参数：将来要调用的目标对象的方法镜像
	//第二个参数：参数列表
	//第三个参数：目标对象
	@Override
	public void before(Method method, Object[] args, Object o)
			throws Throwable {
		log.log("BeforeAdvice log:"+method.getName()+" is invoked ...");
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	

}
