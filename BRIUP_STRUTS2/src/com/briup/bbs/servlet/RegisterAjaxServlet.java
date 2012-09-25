package com.briup.bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bbs.pojo.Member;
import com.briup.bbs.service.MemberService;
import com.briup.bbs.service.impl.MemberServiceImpl;

public class RegisterAjaxServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain");
		PrintWriter pw = resp.getWriter();
		String memberName = req.getParameter("memberName");
		String memberEmail = req.getParameter("memberEmail");
		MemberService memberService = new MemberServiceImpl();
		if(null!=memberName){
			Member member = memberService.findMemberByName(memberName);
			if(null==member){
				pw.println("该用户名可用!:green");
			}else{
				pw.println("该用户名已被占用, 请尝试其他用户名!:red");
			}
		}
		if(null!=memberEmail){
			Member member = memberService.findMemberByEmail(memberEmail);
			if(null==member){
				pw.println("该邮箱可用!:green");
			}else{
				pw.println("该邮箱已被占用, 请尝试其他邮箱!:red");
			}
		}
		pw.flush();
		pw.close();
	}
	

}
