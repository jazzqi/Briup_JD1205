package com.briup.ch09;

import java.util.*;

public class TreeSetTest{//TreeSet is in order, and has no repeat
	public static void main(String args[]){
		Set s= new TreeSet(new Comparator(){
			public int compare(Object o1,Object o2){
				if(o1 instanceof Account && o2 instanceof Account){
			   		Account a1=(Account)o1;
			       	Account a2=(Account)o2;
			       	return a1.getCode()-a2.getCode();
			    }else
			    	return 0;//Don't allow uncompatible type to get in
			}
		});

		Set s2=new TreeSet();
		Account a1=new Account(1001,1000.00);
		Account a2=new Account(1002,3000.00);
		Account a3=new Account(1006,2000.00);
		Account a4=new Account(1004,6000.00);
		Account a5=new Account(1001,2020.00);
		s.add(a1);
		s.add(a2);
		s.add(a3);
		s.add(a4);
		s.add(a5);
		s2.add(a1);
		s2.add(a2);
		s2.add(a3);
		s2.add(a4);
		s2.add(a5);
		Iterator i=s2.iterator();
		while(i.hasNext()){
			System.out.println(((Account)i.next()).toString());
		}
	}
}
