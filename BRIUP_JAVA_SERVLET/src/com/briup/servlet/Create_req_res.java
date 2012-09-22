package com.briup.servlet;

public class Create_req_res {

	public HttpServletRequest getRequest(final String method) {
		// TODO Auto-generated method stub
		HttpServletRequest request=new HttpServletRequest(){
			public String getMethod(){
				return method;
			}
		};
		return request;
	}

	public HttpServletResponse getResponse(final String method) {
		// TODO Auto-generated method stub
		HttpServletResponse response=new HttpServletResponse(){};
		return response;
	}

}
