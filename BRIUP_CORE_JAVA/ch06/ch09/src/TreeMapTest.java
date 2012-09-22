package com.briup.ch09;
import java.util.*;

public class TreeMapTest{
	public static void main(String args[]){
		Map m=new TreeMap(new Comparator(){
			public int compare(Object o1,Object o2){
				return Integer.valueOf((String)o1)-Integer.valueOf((String)o2);
			}
		});
		m.put("10","aaa");
		m.put("20","bb");
		m.put("1","c");
		m.put("3","xdd");
		m.put("5","eee");

		Set mSet=m.entrySet();
		Iterator i=mSet.iterator();
		while(i.hasNext()){
			Map.Entry e=(Map.Entry)i.next();
			System.out.println(e.getKey()+"==>"+e.getValue());
		}
	}
}
