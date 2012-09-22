package com.briup.servlet;

public abstract class GenericServlet implements Servlet {
	public abstract void service(ServletRequest req, ServletResponse res);
	
}
