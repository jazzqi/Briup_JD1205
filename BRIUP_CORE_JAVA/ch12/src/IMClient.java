package com.briup.ch12;

import java.net.*;
import java.io.*;

public class IMClient{
	public static void main(String args[]){
		PrintWriter pw=null;
		Socket server=null;
		BufferedReader br=null;

		try{
			server=new Socket("localhost",8889);
			while(true){
				pw=new PrintWriter(server.getOutputStream());
				br=new BufferedReader(new InputStreamReader(System.in));
				pw.println(br.readLine());
				pw.flush();
			}
		}catch(Exception e){
		}finally{
			try{
				server.close();
				pw.close();
				br.close();
			}catch(Exception e){}
		}
	}
}
