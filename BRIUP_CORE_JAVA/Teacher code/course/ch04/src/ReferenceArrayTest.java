package com.briup.ch04;

public class ReferenceArrayTest{
	public static void main(String[] args){
		Student[] sArray = {new Student("zhangsan",20,true,10001),new Student("lisi",21,false,10002)};
		System.out.println(sArray[0]);

		Student[] sArray2 = new Student[2];
		sArray2[0] = sArray[0];
		System.out.println(sArray2[0]);
		System.out.println(sArray[0]);
		sArray2[0].showInfo();
	}
}
