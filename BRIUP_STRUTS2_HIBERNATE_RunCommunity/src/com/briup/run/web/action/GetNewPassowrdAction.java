package com.briup.run.web.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import com.briup.run.common.exception.MemberServiceException;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.impl.MemberService;
import com.opensymphony.xwork2.ActionSupport;

public class GetNewPassowrdAction extends ActionSupport {

	private final MemberService memberService = (MemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	private InputStream inputStream;
	private String nickname;
	private String passwordquestion;
	private String passwordanswer;
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPasswordquestion() {
		return passwordquestion;
	}

	public void setPasswordquestion(String passwordquestion) {
		this.passwordquestion = passwordquestion;
	}

	public String getPasswordanswer() {
		return passwordanswer;
	}

	public void setPasswordanswer(String passwordanswer) {
		this.passwordanswer = passwordanswer;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {
		String newPwd = "";
		try{
			//newPwd = memberService.getBackPasswd(member.getNickname(), member.getPasswordquestion(), member.getPasswordanswer());
			newPwd = memberService.getBackPasswd(nickname, passwordquestion, passwordanswer);
		} catch(MemberServiceException e){
			e.printStackTrace();
		}
		if(null != newPwd){
			inputStream = new StringBufferInputStream(newPwd);
		}else{
			inputStream = new StringBufferInputStream("0");
		}
		return SUCCESS;
	}

}
