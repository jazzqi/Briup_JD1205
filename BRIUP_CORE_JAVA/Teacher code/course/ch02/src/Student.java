package com.briup.ch02;

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
	public void eat(){
		System.out.println(name+"is eating!");
	}
	public void study(){
		System.out.println(name+"is studing!");
	}
	public void sleep(){
		System.out.println(name+"is sleeping!");
	}
	public static void main(String[] args){
		Student s1 = new Student("zhangsan",20,true,10001);
		s1.eat();
		s1.study();
		s1.sleep();

	}
}
