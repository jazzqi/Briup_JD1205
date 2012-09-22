package com.briup.ch06;

public class Person{
	private String name;
	private boolean gender;
	private int age;

	public void show(){
		System.out.println("name="+getName());
		System.out.println("gender="+(getGender()?"male":"female"));
		System.out.println("age="+getAge());
	}

	public Person(String name,boolean gender,int age){
		this.name=name;
		this.gender=gender;
		this.age=age;
	}
	
	public Person(String name,boolean gender){
		this(name,gender,23);
	}

	public Person(String name,int age){
		this(name,true,age);
	}

	public Person(String name){
		this(name,true);
	}

	public Person(){
		this("Unknown Person");
	}

	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}

	public void setGender(boolean gender){
		this.gender=gender;
	}

	public boolean getGender(){
		return gender;
	}

	public void setAge(int age){
		this.age=age;
	}

	public int getAge(){
		return age;
	}
}
