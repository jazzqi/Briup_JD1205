package com.briup.ch05;

public class Student{
	String name;
	String gender;
	int age;

	public Student(String name,String gender,int age){
		this.name=name;
		this.gender=gender;
		this.age=age;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
}
