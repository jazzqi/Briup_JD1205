package com.briup.ch11;

import java.io.*;

public class RandomAccessFileTest{
	public static void main(String args[]){
		RandomAccessFile rf=null;
		try{
			rf=new RandomAccessFile(new File("randomaccessfile.txt"),"rw");
			rf.seek(50);
			String s="";
			while((s=rf.readLine())!=null){
				System.out.println(s);
			}
			System.out.println(rf.length());
		}catch(Exception e){}
		finally{
			try{
				rf.close();
			}catch(Exception e){}
		}
	}
}
