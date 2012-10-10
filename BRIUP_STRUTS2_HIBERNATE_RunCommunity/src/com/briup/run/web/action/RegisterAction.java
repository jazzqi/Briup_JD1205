package com.briup.run.web.action;

import org.apache.struts2.ServletActionContext;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.impl.MemberService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private Memberinfo member;
	private final MemberService memberService = (MemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);

	public Memberinfo getMember() {
		return member;
	}

	public void setMember(Memberinfo member) {
		this.member = member;
	}

	@Override
	public String execute() throws Exception {
		//isExist?
		Memberinfo m = memberService.findMemberinfoByName(member.getNickname());
		if(null == m){
			memberService.registerMemberinfo(member);
			ServletActionContext.getContext().getSession().put("member", memberService.findMemberinfoByName(member.getNickname()));
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

}
