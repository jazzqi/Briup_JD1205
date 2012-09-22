package com.briup.ch12;

import java.io.*;
import java.net.*;
import java.util.Date;

public class MyServer{
	public static void main(String args[]){
		ServerSocket listener=null;
		Socket instance=null;
		PrintWriter pw=null;
		BufferedReader br=null;

		try{
			listener=new ServerSocket(8889);
			while(true){
				instance=listener.accept();
				System.out.println("=======new client========");
				br=new BufferedReader(new InputStreamReader(instance.getInputStream()));
				String msg=br.readLine();
				System.out.println(msg+" "+instance.getInetAddress().getHostAddress());

				Thread.sleep(5000);

				pw=new PrintWriter(instance.getOutputStream());
				pw.println("Now is "+new Date());
				pw.println("Kan ni mei a!");
				pw.flush();

				instance.close();
				pw.close();
				br.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
