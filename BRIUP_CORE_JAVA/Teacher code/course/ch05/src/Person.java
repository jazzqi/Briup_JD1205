package com.briup.ch05;

public class Person{
	public String name;//attribute
	public boolean gender;
	public int age;
	
	public Person(String name,boolean gender,int age){
		this.name = name;
		this.gender = gender;
		this.age = age;
		System.out.println("first");
	}
	public Person(String name,boolean gender){
		this(name,gender,18);
		System.out.println("seconder!");
	}
	public Person(String name){
		this(name,true);
		System.out.println("third");
	}
	public Person(){
		this("Unkown");
		System.out.println("fourth");
	}
	public void setName(String name){//property
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setGender(boolean gender){
		this.gender = gender;
	}
	public String getGender(){
		if(gender){
			return "male";
		}else
			return "female";
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
}
class PersonTest{
	public static void main(String[] args){
		Person p = new Person();
		p.setName("zhangsan");
		p.setGender(true);
		p.setAge(18);
		System.out.println("Person p name="+p.getName()+"\t Gender="+p.getGender()+"\t age="+p.getAge());

		Person p1 = new Person("one",false,20);
		Person p2 = new Person("two",true);
		Person p3 = new Person("three");
		
	}
}
