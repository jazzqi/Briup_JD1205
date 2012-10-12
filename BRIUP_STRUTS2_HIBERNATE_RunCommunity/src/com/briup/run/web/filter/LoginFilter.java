package com.briup.run.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	private String infoPage;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		if(null != session.getAttribute("member")){
			//已经登录
			chain.doFilter(request, response);
		} else if(request.getRequestURI().trim().split("/")[3].toLowerCase().contains("login")||request.getRequestURI().trim().split("/")[3].toLowerCase().contains("register")){
			//登录中
			chain.doFilter(request, response);
		} else{
			//未登录
			response.sendRedirect(this.infoPage);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.infoPage = config.getInitParameter("infoPage");

	}

}
