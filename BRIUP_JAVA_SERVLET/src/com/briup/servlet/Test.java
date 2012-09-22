package com.briup.servlet;

public class Test {
	public static void main(String args[]){
		Tomcat cat=new Tomcat();
		cat.process("POST /helloServlet http/1.1");
	}

}
