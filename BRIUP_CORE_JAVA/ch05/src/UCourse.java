package com.briup.ch05;

public class UCourse extends Course{
	private int age;
	
	public UCourse(){
		super.setName("English");
		super.setDays(100);
		super.setC_no(1001);
		System.out.println("Sub(0)");
	}
	public static void main(String args[]){
		//Course c=new UCourse("Mathmatic",100,1001);

		/**By default, this will call the default constructor(without of parameters) of superclass*/
		Course c=new UCourse();
		//c.name="English";
		c.show();
	}
}
