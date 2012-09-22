package com.briup.ch12;

import java.io.*;
import java.net.*;

public class MyClient{
	public static void main(String args[]){
		BufferedReader br=null;
		PrintWriter pw=null;
		Socket server=null;

		try{
			server=new Socket("localhost",8889);
			pw=new PrintWriter(server.getOutputStream());
			pw.println("Pls give me your time:");
			pw.flush();

			br=new BufferedReader(new InputStreamReader(server.getInputStream()));
			String msg="";
			while((msg=br.readLine())!=null)
				System.out.println(msg);
		}catch(Exception e){}
		finally{
			try{
				br.close();
				pw.close();
				server.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
