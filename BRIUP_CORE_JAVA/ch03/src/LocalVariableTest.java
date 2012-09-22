package com.briup.ch03;

/**This is an class to test the wrong using of local variable, cannot be used*/
public class LocalVariableTest{
	public void correctLocalV(){
		int x;
		int y=10;
		x=20;
		int z= x+y;
		String str="hello";
		String str1=new String("world");
		char ch;
		ch='c';
	}
	public void incorrectLocalV(){
		int x,z;
		int y=10;
		if(y>20)
			z=x+y;
		String str;
		String str1="Hello"+new String("World")+str;
	}
}
