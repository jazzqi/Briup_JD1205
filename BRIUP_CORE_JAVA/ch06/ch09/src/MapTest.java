package com.briup.ch09;
import java.util.*;

public class MapTest{
	public static void main(String args[]){
		Map m=new HashMap();
		m.put("1",new Integer(10));
		m.put("a","aaaaa");
		m.put("1001",new Account(1001,1000.00));
		System.out.println(m.get("1001").toString());

		Map accountM=new HashMap();
		accountM.put("1001",new Account(1001,1000.00));
		accountM.put("1002",new Account(1002,2000.00));
		accountM.put("1003",new Account(1003,3000.00));
		accountM.put("1004",new Account(1004,4000.00));
		accountM.put("1005",new Account(1005,5000.00));

		Set keyset=accountM.keySet();
		Iterator i=keyset.iterator();
		while(i.hasNext()){
			String key=(String)i.next();
			Account a=(Account)accountM.get(key);
			System.out.println(a);
		}

		Set entryset=accountM.entrySet();
		i=entryset.iterator();
		while(i.hasNext()){
			Map.Entry e=((Map.Entry)i.next());
			System.out.println(e.getKey()+"||||"+e.getValue());
		}
	}
}
