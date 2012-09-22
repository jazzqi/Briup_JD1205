package com.briup.ch06;

public class Teacher extends Person{
	private int t_no;

	public void show(){
		super.show();
		System.out.println("t_no="+getT_no());
	}

	public void setT_no(int t_no){
		this.t_no=t_no;
	}

	public int getT_no(){
		return t_no;
	}

	public Teacher(String name,boolean gender,int age,int t_no){
		super(name,gender,age);
		setT_no(t_no);
	}

	public Teacher(String name,boolean gender,int t_no){
		this(name,gender,18,t_no);
	}

	public Teacher(String name,int age,int t_no){
		this(name,true,age,t_no);
	}

	public Teacher(String name,int t_no){
		this(name,38,t_no);
	}

	public Teacher(int t_no){
		this("UnknownTeacher",t_no);
	}

	public Teacher(){
		this(0);
	}
}
