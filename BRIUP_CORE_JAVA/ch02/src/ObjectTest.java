package com.briup.ch02;

public class ObjectTest{
	public static void main(String args[]){
		Student s1=new Student("Zhangsan",22,true,100);
		s1.eat();
		s1.study();
		s1.sleep();
	}
}
class Student{
	private String name;
	private int age;
	private boolean gender;//true stands for male, and false stands for female
	private int no;

	public Student(String name,int age,boolean gender,int no){
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.no=no;
	}
	public void eat(){
		System.out.println(name+" 正在吃饭！");
	}
	public void study(){
		System.out.println(name+" 正在学习！");
	}
	public void sleep(){
		System.out.println(name+" 正在睡觉！");
	}
}
