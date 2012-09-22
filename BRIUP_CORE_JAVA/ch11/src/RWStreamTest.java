package com.briup.ch11;

import java.io.*;

public class RWStreamTest{
	public static void main(String args[]){
		BufferedWriter bw=null;
		BufferedReader br=null;
		try{
			String s="javac：编译java的命令";
			bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("rwstream.txt"),"GB2312"));
			bw.write(s);
			bw.flush();
			
			br=new BufferedReader(new InputStreamReader(new FileInputStream("rwstream.txt"),"GB2312"));
			System.out.println(br.readLine());
		}catch(Exception e){}
		finally{
			try{
				bw.close();
				br.close();
			}catch(Exception e){}
		}
	}
}
