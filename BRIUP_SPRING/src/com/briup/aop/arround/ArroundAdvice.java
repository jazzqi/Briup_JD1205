package com.briup.aop.arround;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.briup.log.Logger;

public class ArroundAdvice implements MethodInterceptor{
	private Logger log;

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		log.log(method.getMethod().getName()+" is invoked... ");
		Object returnValue = method.proceed();
		log.log(method.getMethod().getName()+" is ended...");
		return returnValue;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

}
