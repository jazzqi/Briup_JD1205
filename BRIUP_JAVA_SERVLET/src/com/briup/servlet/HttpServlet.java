package com.briup.servlet;

public abstract class HttpServlet extends GenericServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res){
		System.out.println("405 doGet() ����֧��~ ���r�]�Ќ��F");
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res){
		System.out.println("405 doPost() ����֧��~ ���r�]�Ќ��F");
	}

	protected void service(HttpServletRequest req, HttpServletResponse res) {
		String method=req.getMethod();
		if(method.equals("GET")){
			doGet(req,res);
		}else if(method.equals("POST")){
			doPost(req,res);
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) {
		// TODO Auto-generated method stub
		service((HttpServletRequest)req, (HttpServletResponse)res);
	}

}
