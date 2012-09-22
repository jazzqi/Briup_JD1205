package com.briup.ch05;

public class Course{
	private String name;
	private int days;
	private int c_no;

	public Course(String name,int days,int c_no){
		this.name = name;
		this.days = days;
		this.c_no = c_no;
	}
	public Course(String name,int days){
		this(name,days,0000);
	}
	public Course(String name){
		this(name,0);
	}
	public Course(){
		this("Unkown");
		System.out.println("Super()");
	}
	public void show(){
		System.out.println("welcome to super class!");
	}
}
