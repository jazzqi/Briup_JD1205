package com.briup.ch05;

public class Course{
	private String name;
	private int days;
	private int c_no;

	public void setName(String name){
		this.name=name;
	}
	public void setDays(int days){
		this.days=days;
	}
	public void setC_no(int c_no){
		this.c_no=c_no;
	}
	public String getName(){
		return name;
	}
	public int getDays(){
		return days;
	}
	public int getC_no(){
		return c_no;
	}
	
	public Course(String name,int days,int c_no){
		this.setName(name);
		this.setDays(days);
		this.setC_no(c_no);
		System.out.println("Super(3)");
	}
	public Course(String name,int days){
		this(name,days,0000);
		System.out.println("Super(2)");
	}
	public Course(String name){
		this(name,0);
		System.out.println("super(1)");
	}
	public Course(){
		this("Unknown");
		System.out.println("Super(0)");
	}
	public void show(){
		System.out.println("Welcome to super class! ");
		System.out.println("The course is "+getName()+"\tdays:"+getDays()+"\tc_no:"+getC_no());
	}
}
