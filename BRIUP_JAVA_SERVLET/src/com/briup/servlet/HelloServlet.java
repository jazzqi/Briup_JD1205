package com.briup.servlet;

public class HelloServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res){
		super.doGet(req, res);
		System.out.println("Hello World!");
	}
}
