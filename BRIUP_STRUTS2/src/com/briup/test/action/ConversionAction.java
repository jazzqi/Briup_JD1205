package com.briup.test.action;

import com.briup.bbs.pojo.Member;
import com.opensymphony.xwork2.ActionSupport;

public class ConversionAction extends ActionSupport{
	private Member member;
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String execute(){
		System.out.println(member.getName());
		System.out.println(member.getEmail());
		System.out.println(member.getAge());
		System.out.println(member.getTele());
		return SUCCESS;
	}
}
