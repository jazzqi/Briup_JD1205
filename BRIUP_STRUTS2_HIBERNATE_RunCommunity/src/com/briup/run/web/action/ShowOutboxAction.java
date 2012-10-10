package com.briup.run.web.action;

import java.util.List;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Messagerecord;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.IMessengerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowOutboxAction extends ActionSupport {
	private final IMessengerService messengerService = (IMessengerService) BeanFactory.getBean(BeanFactory.MESSENGERSERVICE);

	@Override
	public String execute() throws Exception {
		List<Messagerecord> outbox = messengerService.listSendMessage(((Memberinfo)ActionContext.getContext().getSession().get("member")).getNickname());
		ActionContext.getContext().getValueStack().set("outbox", outbox);
		return super.execute();
	}

}
