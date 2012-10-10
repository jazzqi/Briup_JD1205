package com.briup.run.web.action;

import org.apache.struts2.ServletActionContext;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.IMemberService;
import com.opensymphony.xwork2.ActionSupport;

public class IsCreateSpaceAction extends ActionSupport {
	private String member_nickname;
	private final IMemberService memberService = (IMemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	

	public String getMember_nickname() {
		return member_nickname;
	}



	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}



	@Override
	public String execute() throws Exception {
		Memberinfo member = memberService.findMemberinfoByName(member_nickname);
		if(null != member){
			ServletActionContext.getContext().put("member_nickname", member.getNickname());
			return memberService.isMemberspace(member.getId())?"hasspace":"nospace";
		}
		return ERROR;
	}

}
