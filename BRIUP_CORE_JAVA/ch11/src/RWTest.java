package com.briup.ch11;

import java.io.*;

public class RWTest{
	public static void main(String args[]){
		BufferedWriter bw=null;
		BufferedReader br=null;
		try{
			bw=new BufferedWriter(new FileWriter("rw.txt"));
			bw.write("Hello this is test words writen by bufferedWriter\n\rline 2\nline 3\rline 4");
			bw.flush();
			br=new BufferedReader(new FileReader("rw.txt"));
			String a;
			while(!(a=br.readLine()).equals(null))
				System.out.println(a);
		}catch(Exception e){}finally{
			try{
				bw.close();
			}catch(Exception e){}
		}
	}
}
