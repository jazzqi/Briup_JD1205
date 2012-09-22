package com.briup.bbs.test;

import com.opensymphony.xwork2.ActionSupport;

public class ErrorAction extends ActionSupport{
	@Override
	public String execute(){
		return ERROR;
	}
}
