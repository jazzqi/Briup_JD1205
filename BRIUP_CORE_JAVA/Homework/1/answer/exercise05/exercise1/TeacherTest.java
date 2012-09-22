package com.md05;

public class TeacherTest 
{
	public static void main(String[] args) 
	{
		Teacher t = new Teacher();
		
//		t.name = "George";
//		t.age = 30;
//		t.salary = 10000;
		t.setName("George");
		t.setAge(30);
		t.setSalary(10000);

		System.out.println("name=" + t.getName());
		System.out.println("age=" + t.getAge());
		System.out.println("salary=" + t.getSalary());

		t.increaseAge();
		System.out.println("new age=" + t.getAge());
	}
}
