package com.briup.run.web.action;

import java.util.List;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Messagerecord;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.IMemberService;
import com.briup.run.service.IMessengerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ViewMessageAction extends ActionSupport {
	private String id;
	private final IMessengerService messengerService = (IMessengerService) BeanFactory.getBean(BeanFactory.MESSENGERSERVICE);

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}


	public String viewMessage() throws Exception {
		Messagerecord message = messengerService.findMessage(Long.valueOf(id));
		if(null != message){
			ActionContext.getContext().getValueStack().push(message);
		}
		return SUCCESS;
	}
	


}
