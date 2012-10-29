package com.briup.aop.after;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import com.briup.log.Logger;

public class AfterAdvice implements AfterReturningAdvice{
	private Logger log;

	//参数列表：
	//目标对象中方法执行完之后的返回结果
	//目标对象中方法的镜像
	//目标对象中方法的参数列表
	//目标对象
	@Override
	public void afterReturning(Object returnValue, Method m, Object[] args,
			Object target) throws Throwable {
		// TODO Auto-generated method stub
		log.log(m.getName()+" is end... returnValue="+returnValue);
		
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	

}
