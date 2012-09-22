package com.md05;

public class StudentTest 
{
	public static void main(String[] args) 
	{
		Student s = new Student("steven","male",30);
		
		System.out.println("name=" + s.getName());
		System.out.println("gender=" + s.getGender());
		System.out.println("age=" + s.getAge());
	}
}
