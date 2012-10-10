package com.briup.run.web.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.List;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.util.BeanFactory;
import com.briup.run.service.IMessengerService;
import com.opensymphony.xwork2.ActionSupport;

public class MatchFriendAction extends ActionSupport {
	private String age;
	private String gender;
	private String provincecity;
	private InputStream inputStream;
	
	IMessengerService messengerService = (IMessengerService) BeanFactory.getBean(BeanFactory.MESSENGERSERVICE);

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProvincecity() {
		return provincecity;
	}

	public void setProvincecity(String provincecity) {
		this.provincecity = provincecity;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String randomMember() throws Exception {
		Memberinfo member = messengerService.findOneMemberinfo();
		StringBuffer sb = new StringBuffer();
		sb.append("<members>");
		sb.append("<member>");
		sb.append("<nickname>");
		sb.append(member.getNickname());
		sb.append("</nickname>");
		sb.append("<gender>");
		sb.append(member.getGender());
		sb.append("</gender>");
		sb.append("<age>");
		sb.append(member.getAge());
		sb.append("</age>");
		sb.append("<provincecity>");
		sb.append(member.getProvincecity());
		sb.append("</provincecity>");
		sb.append("</member>");
		sb.append("</members>");
		inputStream = new StringBufferInputStream(sb.toString());
		return SUCCESS;
	}
	
	public String queryMember() throws Exception {
		List<Memberinfo> members = messengerService.findFriends(age, gender, provincecity);
		StringBuffer sb = new StringBuffer();
		sb.append("<members>");
		if(null != members && 0 != members.size()){
			for(Memberinfo member : members){
				sb.append("<member>");
				sb.append("<nickname>");
				sb.append(member.getNickname());
				sb.append("</nickname>");
				sb.append("<gender>");
				sb.append(member.getGender());
				sb.append("</gender>");
				sb.append("<age>");
				sb.append(member.getAge());
				sb.append("</age>");
				sb.append("<provincecity>");
				sb.append(member.getProvincecity());
				sb.append("</provincecity>");
				sb.append("</member>");
			}
		}
		sb.append("</members>");
		inputStream = new StringBufferInputStream(sb.toString());
		return SUCCESS;
	}

}
