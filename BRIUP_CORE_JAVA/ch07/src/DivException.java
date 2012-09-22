package com.briup.ch07;

public class DivException extends Exception{
	private int a;
	private int b;
	public DivException(int a,int b){
		this.a=a;
		this.b=b;
	}
	public DivException(String message,int a,int b,Throwable cause){
		super(message,cause);
		this.a=a;
		this.b=b;
	}
	public String getMessage(){
		return super.getMessage()+a+"div"+b;
	}
}
