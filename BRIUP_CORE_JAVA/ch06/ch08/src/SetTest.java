package com.briup.ch08;

import java.util.*;

public class SetTest{
	int code=1001;
	public static void main(String args[]){
		Account a1=new Account(1001,1000.00);
		Account a2=new Account(1002,1500.00);
		Account a3=new Account(1003,2000.00);

		Set set=new HashSet();
		set.add(a1);
		set.add(a2);
		set.add(a3);
		set.add(a1);

		Account a4=new Account(1001,1000.00);
		a4.setOpenDate(a1.getOpenDate());
		set.add(a4);
		out_set(set);
	}
	public static void out_set(Set set){
		Iterator i=set.iterator();
		while(i.hasNext()){
			Account a=(Account)i.next();
			a.show();
		}
	}

}

