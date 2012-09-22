package com.briup.ch09;

import java.lang.reflect.*;
import java.util.*;

public class DynReflectTest{
	public static void main(String args[]) throws Exception{
		Class clazz=Class.forName(args[0]);
		Object o=clazz.newInstance();
		if(o instanceof Collection){
			Collection c=(Collection)o;
			c.add("aa");
			c.add("bbb");
			c.add("ccc");
			Iterator i=c.iterator();
			while(i.hasNext()){
				System.out.println(i.next());
			}
		}else
			System.out.println("Not collection class");
	}
}
