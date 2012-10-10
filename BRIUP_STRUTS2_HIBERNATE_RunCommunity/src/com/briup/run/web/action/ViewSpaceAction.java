package com.briup.run.web.action;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Memberspace;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.common.util.Util;
import com.briup.run.service.impl.MemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ViewSpaceAction extends ActionSupport {
	private final MemberService memberService = (MemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	String member_nickname;
	
	@Override
	public String execute() throws Exception {
		Memberinfo member = memberService.findMemberinfoByName(member_nickname);
		if(null != member){
			Memberspace space = memberService.getSpace(member);
			if(null != space){
				String province = Util.getProvinceNameById(member.getProvincecity());
				ActionContext.getContext().getValueStack().push(member);
				ActionContext.getContext().getValueStack().push(space);
				ActionContext.getContext().put("province", province);
				return SUCCESS;
			}
		}
		return ERROR;
	}

	public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	};

}
