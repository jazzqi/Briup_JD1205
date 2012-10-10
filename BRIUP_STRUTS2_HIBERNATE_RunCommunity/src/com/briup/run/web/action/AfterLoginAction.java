package com.briup.run.web.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.impl.MemberService;
import com.opensymphony.xwork2.ActionSupport;

public class AfterLoginAction extends ActionSupport implements SessionAware{
	private final MemberService memberService = (MemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	private Map<String,Object> session;
	
	@Override
	public String execute() throws Exception {
		// 获取积分排前十的用户
		List<Memberinfo> topmembers = memberService.findMemberinfoByNum(10);
		session.put("topmembers", topmembers);
		// 查询当前用户的新短信数量
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
