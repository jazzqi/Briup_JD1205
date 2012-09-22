package com.briup.ch06;

public class Student extends Person{
	private int s_no;

	public void show(){
		super.show();
		System.out.println("s_no="+getS_no());
	}

	public Student(String name,boolean gender,int age,int s_no){
		super(name,gender,age);
		setS_no(s_no);
	}
	public Student(String name,int age,int s_no){
		this(name,true,age,s_no);
	}
	public Student(String name,boolean gender,int s_no){
		this(name,gender,19,s_no);
	}
	public Student(String name,int s_no){
		this(name,true,s_no);
	}
	public Student(int s_no){
		this("UnknownStudent",s_no);
	}
	public Student(){
		this(0);
	}
	public void setS_no(int s_no){
		this.s_no=s_no;
	}

	public int getS_no(){
		return s_no;
	}
}
