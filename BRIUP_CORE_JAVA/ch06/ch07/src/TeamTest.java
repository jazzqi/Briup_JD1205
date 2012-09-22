package com.briup.ch07;

public class TeamTest{
	public static void main(String args[]){
		Student s1=new Student("zhangsan",18);
		Student s2=new Student("lisi",19);
		Student s3=new Student("wangwu",22);
		Student s4=new Student("zhangliu",19);

		Team t=new Team(3);
		t.addStudent(s1);
		t.addStudent(s2);
		t.addStudent(s3);
		t.addStudent(s4);
		//t.showAllStudents();
		System.out.println("Min age:");
		System.out.println(t.getMaxOrMin(new AgeComparator()).getAge());
		System.out.println("Max code:");
		System.out.println(t.getMaxOrMin(new CodeComparator()).getCode());
	}
}

class AgeComparator extends Comparator{
	public int compare(Student s1,Student s2){
		return s2.getAge()-s1.getAge();
	}
}

class CodeComparator extends Comparator{
	public int compare(Student s1,Student s2){
		return s1.getCode()-s2.getCode();
	}
}
