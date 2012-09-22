package com.briup.ch06;

public class Test{
	public static void show(Person p){
		p.show();
	}

	public static void main(String args[]){
		System.out.println("--------------------");

		Person p=new Person("zhangsan",true,18);
		show(p);

		System.out.println("--------------------");

		p=new Teacher("briup",true,30,1001);
		show(p);

		System.out.println("--------------------");

		p=new Student("jd1205",true,22,2001);
		show(p);

		System.out.println("--------------------");

		Person p1=new Person();
		Person t1=new Teacher();
		Person s1=new Student();
		Student ss=new Student();


		t1=p1;
		show(t1);

		System.out.println("--------------------");

		p1=s1;

		//System.out.println("p1 instanceof Student:"+(p1 instanceof Student)); //==>true
		//if(p1 instanceof Student)
		//	ss=p1;
		//else
			ss=(Student)p1;
		show(ss);

		System.out.println("--------------------");
	}
}

