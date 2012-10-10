package com.briup.run.web.action;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CheckAutoLoginAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loginname")) {
				session.put("loginname", cookie.getValue());
			} else if (cookie.getName().equals("password")) {
				session.put("password", cookie.getValue());
			}
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		session = arg0;
	}

}
