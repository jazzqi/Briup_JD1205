package com.briup.ch12;

import java.net.*;
import java.io.*;

public class IMServer{
	public static void main(String args[]){
		BufferedReader br=null;
		PrintWriter pw=null;
		ServerSocket server=null;
		Socket client=null;

		try{
			server=new ServerSocket(8889);
			while(true){
				client=server.accept();
				br=new BufferedReader(new InputStreamReader(client.getInputStream()));
				String msg=br.readLine();
				System.out.println("========NEW INFO FROM "+client.getInetAddress().getHostAddress()+"========");
				System.out.println(msg);
				
				//pw=new PrintWriter();
			}
		}catch(Exception e){}
	}
}
