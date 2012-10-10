package com.briup.run.web.action;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.IMemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddBlackAction extends ActionSupport {
	private String member_nickname;
	private final IMemberService memberService = (IMemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE); 

	public String getMember_nickname() {
		return member_nickname;
	}


	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}


	@Override
	public String execute()throws Exception{
		
		Memberinfo friend = memberService.findMemberinfoByName(member_nickname);
		Memberinfo member = (Memberinfo) ActionContext.getContext().getSession().get("member");
		memberService.moveToBlack(member.getNickname(), member_nickname);
		return SUCCESS;
	}
}
