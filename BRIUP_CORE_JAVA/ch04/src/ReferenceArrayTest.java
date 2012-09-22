package com.briup.ch04;

public class ReferenceArrayTest{
	public static void main(String args[]){
		/**Illegal syntax*/
		//Student[] sArray;
		//sArray={new Student("zhangsan",20,true,1000)}

		//The good way
		/**Declare and initial an array with 2 postion*/
		Student[] sArray={new Student("zhangsan",20,true,1000),new Student("lisi",21,true,1500)};
		System.out.println(sArray[0]);

		/**ArrayIndexOutofBoundsException*/
		//sArray[2]=new Student("wangwu",22,false,1800);

		/**Declare and initial an array with default value*/
		Student[] sArray2=new Student[2];

		/**NullPointerException*/
		//sArray2[0].showInfo();
		
		sArray2[0]=sArray[0];
		/**The two array references the same object*/
		System.out.println(sArray2[0]);
		sArray2[0].showInfo();
	}
}
