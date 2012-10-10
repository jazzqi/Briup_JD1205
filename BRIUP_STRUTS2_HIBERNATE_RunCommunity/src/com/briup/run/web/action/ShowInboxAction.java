package com.briup.run.web.action;

import java.util.List;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Messagerecord;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.IMessengerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowInboxAction extends ActionSupport {
	private final IMessengerService messengerService = (IMessengerService) BeanFactory.getBean(BeanFactory.MESSENGERSERVICE);

	@Override
	public String execute() throws Exception {
		Memberinfo member = (Memberinfo)ActionContext.getContext().getSession().get("member");
		List<Messagerecord> inbox = messengerService.listRecieveMessage(member.getNickname());
		ActionContext.getContext().getValueStack().set("inbox", inbox);
		return SUCCESS;
	}
}
