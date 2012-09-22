package com.briup.ch05;

public class Person{
	public String name;
	public int age;
	public boolean gender;

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public void setAge(int age){
		this.age=age;
	}

	public int getAge(){
		return age;
	}

	public void setGender(boolean gender){
		this.gender=gender;
	}

	public boolean getGender(){
		return gender;
	}
	public Person(String name,boolean gender,int age){
		this.name=name;
		this.age=age;
		this.gender=gender;
		System.out.println("first constructor");
	}
	public Person(String name,boolean gender){
		this(name,gender,18);
		//this.name=name;
		//this.gender=gender;
		//age=18;
		System.out.println("second constructor");
	}
	public Person(String name){
		this(name,true,18);
		//this.name=name;
		//gender=true;
		//age=18;
		System.out.println("third constructor");
	}
	public Person(){
		this("Unknown",true,18);
		//name="Unkonwn";
		//gender=true;
		//age=18;
		System.out.println("fourth constructor");
	}
}

class PersonTest{
	public static void main(String args[]){
		Person p =new Person();
		//p.name="zhansan";
		//p.gender=true;
		//p.age=18;
		p.setName("zhangsan");
		p.setAge(18);
		p.setGender(true);
		System.out.println("Person p name="+p.getName()+"\tage="+p.getAge()+"\tgender="+(p.getGender()?"male":"female"));

		Person p1=new Person("one",false,20);
		Person p2=new Person("two",true);
		Person p3=new Person("three");
	}
}
