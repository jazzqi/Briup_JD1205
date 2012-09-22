package com.briup.ch03;

public class ReferenceTest{
	String name;
	int age;
	int salary;
	boolean gender;

	public ReferenceTest(String name,int age,int salary,boolean gender){
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
	}
	public void displayInfo(){
		System.out.println("name="+name);
		System.out.println("age ="+age);
		System.out.println("salary="+salary);
		System.out.println("gender="+gender);
	}
	public static void main(String[] args){
		ReferenceTest r1,r2;
		r1 = new ReferenceTest("zhangsan",20,1000,true);
		r2 = r1;
		r2.name = "lisi";
		r1.displayInfo();
		System.out.println("===========");
		r2.displayInfo();
	}

}
