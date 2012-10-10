package com.briup.run.web.action;

import java.util.List;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.IMemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowBlackAction extends ActionSupport {
	private final IMemberService memberService = (IMemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	
	@Override
	public String execute() throws Exception {
		Memberinfo member = (Memberinfo) ActionContext.getContext().getSession().get("member");
		List<Memberinfo> black = memberService.listBlack(member.getNickname());
		if(null != black && black.size()>=0){
			ActionContext.getContext().getValueStack().set("black", black);
		}	
		return SUCCESS;
	}
}
