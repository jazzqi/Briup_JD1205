package com.briup.bbs.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import com.briup.bbs.pojo.Member;
import com.briup.bbs.service.MemberService;
import com.briup.bbs.service.impl.MemberServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class showMemberAction extends ActionSupport {
	private InputStream inputStream;
	private String memberName;
	private final MemberService memberService = new MemberServiceImpl();

	@Override
	public String execute() {
		Member member = memberService.findMemberByName(memberName);
		StringBuffer buff = new StringBuffer();
		buff.append("<member>");
		buff.append("<name>");
		buff.append(member.getName());
		buff.append("</name>");
		buff.append("<age>");
		buff.append(member.getAge());
		buff.append("</age>");
		buff.append("<gender>");
		buff.append(member.getGender());
		buff.append("</gender>");
		buff.append("<email>");
		buff.append(member.getEmail());
		buff.append("</email>");
		buff.append("<tele>");
		buff.append(member.getTele());
		buff.append("</tele>");
		buff.append("</member>");
		inputStream = new StringBufferInputStream(buff.toString());
		return SUCCESS;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

}
