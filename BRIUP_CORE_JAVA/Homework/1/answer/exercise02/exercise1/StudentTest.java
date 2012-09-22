package com.md02;

public class StudentTest{
	public static void main(String args[]){
		Student s=new Student();

		s.name="jd1205";
		s.gender=true;
		s.age=30;

		System.out.println("name="+s.name);
		System.out.println("gender="+(s.gender?"male":"female"));
		System.out.println("age="+s.age);
	}
}
