package com.briup.ch03;

public class ReferenceTest{
	String name;
	int age;
	int salary;
	boolean gender;
	
	public ReferenceTest(String name,int age,int salary,boolean gender){
		this.name=name;
		this.age=age;
		this.salary=salary;
		this.gender=gender;
	}

	public void displayInfo(){
		System.out.println("name = "+name);
		System.out.println("age = "+age);
		System.out.println("salary = "+salary);
		System.out.println("gender = "+gender);
	}
	
	public static void main(String args[]){
		ReferenceTest rt1,rt2;
		rt1=new ReferenceTest("qifei",23,100000,true);
		rt2=rt1;
		rt1.displayInfo();
		rt2.salary=100000000;
		rt1.displayInfo();
		System.out.println("===================");
		rt2.displayInfo();
	}
}
