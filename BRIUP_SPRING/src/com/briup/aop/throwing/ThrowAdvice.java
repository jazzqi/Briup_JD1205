package com.briup.aop.throwing;

import org.springframework.aop.ThrowsAdvice;

import com.briup.log.Logger;

public class ThrowAdvice implements ThrowsAdvice{

	private Logger log;
	
	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	//在ThrowsAdvice 接口中没有定义抽象方法
	//但是要写一个这样的方法
	//将来抛出异常时会调用
	public void afterThrowing(Throwable e){
		log.log(e.getMessage());
	}
}
