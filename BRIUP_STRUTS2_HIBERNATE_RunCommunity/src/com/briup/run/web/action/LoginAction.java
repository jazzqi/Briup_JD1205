package com.briup.run.web.action;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.common.util.MD5;
import com.briup.run.service.impl.MemberService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private Memberinfo member;
	private String authCode;
	private String autoLogin;
	private final MemberService memberService = (MemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	
	public String getAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(String autoLogin) {
		this.autoLogin = autoLogin;
	}

	public Memberinfo getMember() {
		return member;
	}

	public void setMember(Memberinfo member) {
		this.member = member;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	@Override
	public String execute() throws Exception {
		//使用页面登录
		if(null != member && null != member.getPassword() && null != member.getPassword() && null != authCode){
			if(session.get("authCode").toString().equals(this.authCode)){
				return login(member.getNickname(), MD5.getMD5Str(member.getPassword()));
			}
		}
		//使用cookie登录
		String loginname = (String) ServletActionContext.getContext().getSession().get("loginname");
		String password = (String) ServletActionContext.getContext().getSession().get("password");
		if(null != loginname && null != password){
			//System.out.println("-------------------"+loginname+":"+password);
			return login(loginname, password);
		}
		return INPUT;
	}
	
	private String login(String loginname,String password) throws Exception {
		Memberinfo m = memberService.login(loginname, password);
		if(null != m){
			session.put("member", m);
			//设置自动登录Cookie
			if(null != autoLogin && autoLogin.equals("0")){
				Cookie loginnameCo = new Cookie("loginname",m.getNickname());
				Cookie passwordCo = new Cookie("password",m.getPassword());
				//Cookie有效期90天
				int maxAge = 3*30*24*60*60;
				loginnameCo.setMaxAge(maxAge);
				passwordCo.setMaxAge(maxAge);
				ServletActionContext.getResponse().addCookie(loginnameCo);
				ServletActionContext.getResponse().addCookie(passwordCo);
			}
			return SUCCESS;
		}
		return INPUT;
	}

	@Override
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	
}
