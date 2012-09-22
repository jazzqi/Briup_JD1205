package com.briup.ch09;

import java.lang.reflect.*;
import java.lang.Class;

public class ReflectTest{
	public static void main(String args[]) throws Exception{
		Class clazz=Class.forName("com.briup.ch09.Account");
		String modifiers=Modifier.toString(clazz.getModifiers());
		System.out.println("--------------Modifiers--------------");
		System.out.println(modifiers);
		System.out.println("--------------Interfaces--------------");
		Class[] is=clazz.getInterfaces();
		for(int i=0;i<is.length;i++){
			String iName=is[i].getName();
			System.out.println(iName);
		}
		System.out.println("--------------Fields--------------");
		getFields(clazz);
		System.out.println("------------Contructors----------------");
		getConstructors(clazz);
		System.out.println("------------Methods----------------");
		getMethods(clazz);
	}
	public static void getFields(Class clazz){
		Field[] fs=clazz.getDeclaredFields();
		for(int i=0;i<fs.length;i++){
			System.out.print(Modifier.toString(fs[i].getModifiers())+" ");
			System.out.print(fs[i].getType().getName()+" ");
			System.out.print(fs[i].getName()+";");
			System.out.println();
		}
	}
	public static void getConstructors(Class c){
		Constructor[] cs=c.getDeclaredConstructors();
		for(int i=0;i<cs.length;i++){
			System.out.print(Modifier.toString(cs[i].getModifiers())+" ");
			System.out.print(cs[i].getName()+" ");
			//System.out.print(cs[i].getTypeParameter);
			getParameterTypes(cs[i].getParameterTypes());
			System.out.println();
		}
	}
	public static void getParameterTypes(Class[] c){
		System.out.print("(");
		for(int i=0;i<c.length;i++){
			if(i==c.length-1)
				System.out.print(c[i].getName());
			else
				System.out.print(c[i].getName()+",");
		}
		System.out.print(")");
	}
	public static void getMethods(Class c){
		Method[] m=c.getDeclaredMethods();
		for(int i=0;i<m.length;i++){
			System.out.print(Modifier.toString(m[i].getModifiers())+" ");
			System.out.print(m[i].getReturnType().getName()+" ");
			System.out.print(m[i].getName()+"");
			getParameterTypes(m[i].getParameterTypes());
			System.out.println();
		}
	}
}
