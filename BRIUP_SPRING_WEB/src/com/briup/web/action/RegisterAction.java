package com.briup.web.action;

import com.briup.bean.User;
import com.briup.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	private String name;
	private int age;
	private IUserService service;
	private String info;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user = new User(name,age);
		try {
			service.register(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			info = e.getMessage();
			return ERROR;
		}
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public IUserService getService() {
		return service;
	}

	public void setService(IUserService service) {
		this.service = service;
	}
	
}
