package com.briup.ch08;

public class Student{
	private String name;
	private int age;
	private int code;
	private static int nextCode=100;

	public Student(String name,int age){
		setName(name);
		setAge(age);
		setCode(nextCode++);
	}
	
	public void show(){
		System.out.println("name="+getName()+" age="+getAge()+" code="+getCode());
	}

	public void setName(String name){
		this.name=name;
	}

	public void setAge(int age){
		this.age=age;
	}

	public void setCode(int code){
		this.code=code;
	}
	
	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}

	public int getCode(){
		return code;
	}
}
