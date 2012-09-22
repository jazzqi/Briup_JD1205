package com.briup.ch04;

public class Student{
	private String name;
	private int age;
	private boolean gender;
	private int no;

	public Student(String name,int age,boolean gender,int no){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.no = no;
	}
	public void showInfo(){
		System.out.println("name="+name+"age="+age+"gender="+(gender?"male":"female")+"no="+no);
	}
}
