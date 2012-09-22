package com.briup.bbs.action;

import java.util.Date;

import com.briup.bbs.pojo.Member;
import com.briup.bbs.service.MemberService;
import com.briup.bbs.service.impl.MemberServiceImpl;
import com.briup.bbs.service.impl.TopicServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport {
	private Member member;

	private String name;
	private String password;
	private String gender;
	private String tele;
	private String email;
	private int age;

	private final MemberService memberService = new MemberServiceImpl();

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String register() throws Exception {
		// Member member=new Member();
		member.setRegisteDate(new Date());
		member.setAge(this.member.getAge());
		member.setEmail(this.member.getEmail());
		member.setGender(this.member.getGender());
		member.setName(this.member.getName());
		member.setPassword(this.member.getPassword());
		member.setTele(this.member.getTele());
		try {
			if (memberService.saveOrUpdate(member)) {
				ActionContext.getContext().getSession().put("member", member);
				return "register_success";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "register_failed";
	}

	public String login() throws Exception {
		try {
			Member member = memberService.findMemberByName(this.member
					.getName());
			if (null != member
					&& member.getPassword().equals(this.member.getPassword())) {
				ActionContext.getContext().getSession().put("member", member);
				ActionContext.getContext().getSession()
						.put("topics", new TopicServiceImpl().findAllTopic());
				// 手动压栈，可以直接使用,但是作用域是request，不能用于重定向
				ActionContext.getContext().getValueStack()
						.set("member", member);
				return "login_success";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "login_failed";
	}

	public String modify() throws Exception {
		try {
			Member memeber = memberService.findMemberByName(this.member
					.getName());
			memeber.setAge(this.member.getAge());
			memeber.setEmail(this.member.getEmail());
			memeber.setGender(this.member.getGender());
			memeber.setPassword(this.member.getPassword());
			memeber.setTele(this.member.getTele());
			if (memberService.saveOrUpdate(memeber)) {
				return "modify_success";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "modify_failed";
	}

}
