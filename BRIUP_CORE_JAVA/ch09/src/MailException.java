package com.briup.ch09;

public class MailException extends Exception{
	public MailException(String message){
		super(message);
	}
	public String getMessage(){
		return super.getMessage();
	}
}
