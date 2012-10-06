package com.briup.test.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("deprecation")
public class TestAjaxAction extends ActionSupport{
	private InputStream inputStream;

	public String testAjax(){
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		inputStream = new StringBufferInputStream("Hello Struts ajax 测试中文");
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("<member>");
		strBuf.append("<name>");
		strBuf.append("jd1205");
		strBuf.append("</name>");
		strBuf.append("</member>");
		inputStream = new StringBufferInputStream(strBuf.toString());
		return "test_success";
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
