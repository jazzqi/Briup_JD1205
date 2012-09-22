package com.briup.servlet;

import java.util.HashMap;
import java.util.Map;

public class Tomcat {
	private Map<String,String> container = new HashMap();
	private Map<String,Servlet> container2=new HashMap();
	
	public Tomcat(){
		//解析web.xml文件，獲取其中的url-pattern, servlet-class
		String url="/helloServlet";
		String className="com.briup.servlet.HelloServlet";
		container.put(url, className);
		Class clazz;
		Servlet o;
		try {
			clazz = Class.forName(className);
			o = (Servlet) clazz.newInstance();
			container2.put(url, o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void process(String requestHead){
		String[] str=requestHead.split(" ");
		String method=str[0];
		String url=str[1];
		Create_req_res crr=new Create_req_res();
		HttpServletRequest req=crr.getRequest(method);
		HttpServletResponse res=crr.getResponse(method);
		((Servlet)container2.get(url)).service(req, res);
		
		
	}
}
