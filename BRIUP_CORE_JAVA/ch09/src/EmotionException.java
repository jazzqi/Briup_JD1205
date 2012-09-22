package com.briup.ch09;

public class EmotionException extends Exception{
	public EmotionException(String message){
		super(message);
	}
	public String getMessage(){
		return super.getMessage();
	}
}
