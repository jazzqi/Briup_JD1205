package com.md04;

/*
Teacher and students in classroom.
*/
public class ClassroomTest 
{
	public static void main(String[] args) 
	{
		//创建Classroom对象
		Classroom c=new Classroom();

		//创建Teacher对象，并将Teacher分配到Classroom中
		Teacher t=new Teacher(1001,"briup",20000d,14,30);
		//c.teacher=t;
		c.setTeacher(t);
		
		//创建3个Student对象，并将Student分配到Classroom中
		Student s1=new Student(1,"zhangsan",18);
		c.addStudent(s1);
		Student s2=new Student(2,"lisi",20);
		c.addStudent(s2);
		Student s3=new Student(3,"wangwu",19);
		c.addStudent(s3);

		//调用Classroom中的其它方法，测试方法的业务逻辑是否准确
		c.print();
		c.removeStudent(0);
		c.print();
		c.addStudent(s1);
		c.print();
		
	}
}
