package com.briup.ch11;

import java.io.*;
import java.util.*;

public class ObjectTest{
	public static void main(String args[]){
		Set set=new HashSet();
		Set set2=new HashSet();
		set.add(new String("zhangsan"));
		set.add(new String("lisi"));
		set.add(new String("wangwu"));

		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;

		try{
			oos=new ObjectOutputStream(new FileOutputStream("object.txt"));
			oos.writeObject(set);
			oos.flush();

			ois=new ObjectInputStream(new FileInputStream("object.txt"));
			set2=(Set)ois.readObject();
			Iterator i=set2.iterator();
			while(i.hasNext()){
				System.out.println(i.next());
			}
		}catch(Exception e){}
		finally{
			try{
				oos.close();
				ois.close();
			}catch(Exception e){}
		}
	}
}
