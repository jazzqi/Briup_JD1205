package com.briup.run.web.action;

import java.util.Date;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Messagerecord;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.IMessengerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SendMessageAction extends ActionSupport {
	private Messagerecord message;
	private final IMessengerService messengerService = (IMessengerService) BeanFactory.getBean(BeanFactory.MESSENGERSERVICE);

	public Messagerecord getMessage() {
		return message;
	}

	public void setMessage(Messagerecord message) {
		this.message = message;
	}

	@Override
	public String execute() throws Exception {
		Memberinfo member = (Memberinfo)ActionContext.getContext().getSession().get("member");
		message.setSender(member.getNickname());
		message.setSenddate(new Date());
		message.setReceiverstatus(0l);
		message.setSenderstatus(0l);
		message.setStatus(0l);
		messengerService.saveMessage(message);
		return SUCCESS;
	}

}
