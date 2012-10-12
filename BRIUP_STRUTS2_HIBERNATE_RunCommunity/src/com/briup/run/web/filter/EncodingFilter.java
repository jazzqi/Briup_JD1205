package com.briup.run.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private String encoding;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(null != this.encoding){
			request.setCharacterEncoding(this.encoding);
			response.setCharacterEncoding(this.encoding);
		}
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
	}

}
