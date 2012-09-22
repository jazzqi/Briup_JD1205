package com.briup.ch09;

import java.lang.reflect.*;

public class DesBoxReflectTest{
	public static void main(String args[]) throws Exception{
		Class clazz=A.class;
		Constructor c=clazz.getDeclaredConstructors()[0];
		c.setAccessible(true);
		A a=(A)c.newInstance(new Integer(10));
		Method m=clazz.getDeclaredMethod("display",new Class[]{int.class});
		m.setAccessible(true);
		m.invoke(a,new Integer(50));
		Field f=clazz.getDeclaredField("value");
		f.setAccessible(true);
		f.set(a,new Integer(100));
		m.invoke(a,new Integer(1));
	}
}

class A{
	private int value;
	private A(int value){
		this.value=value;
	}
	private void display(int k){
		System.out.println(value+k);
	}
}
