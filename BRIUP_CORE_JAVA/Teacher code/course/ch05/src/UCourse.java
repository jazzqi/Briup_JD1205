package com.briup.ch05;

public class UCourse extends Course{
	private int age;
	public UCourse(){
		System.out.println("Sub()");
	}

	public static void main(String[] args){
		Course c = new UCourse();
		c.show();
	}
}
