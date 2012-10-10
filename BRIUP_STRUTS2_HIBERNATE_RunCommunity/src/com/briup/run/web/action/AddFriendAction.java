package com.briup.run.web.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.IMemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddFriendAction extends ActionSupport {
	private String member_nickname;
	//private IMessengerService messengerService = (IMessengerService) BeanFactory.getBean(BeanFactory.MESSENGERSERVICE);
	private final IMemberService memberService = (IMemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	private InputStream inputStream;

	public String getMember_nickname() {
		return member_nickname;
	}


	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	@Override
	public String execute() throws Exception {
		Memberinfo friend = memberService.findMemberinfoByName(member_nickname);
		Memberinfo member = (Memberinfo) ActionContext.getContext().getSession().get("member");
		if(null == friend){
			//找不到用户
			inputStream = new StringBufferInputStream("not found");
			//return ERROR;
		}else if(null != memberService.findFriend(member.getNickname(),member_nickname)){
			//对方已经是好友
			inputStream = new StringBufferInputStream("already");
			//return SUCCESS;
		}else{
			memberService.saveOrUpdate(member.getNickname(), member_nickname);
			inputStream = new StringBufferInputStream("ok");
			//return SUCCESS;
		}
		return SUCCESS;
	}

}
