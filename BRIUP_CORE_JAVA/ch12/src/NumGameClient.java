package com.briup.ch12;

import java.io.*;
import java.net.*;

public class NumGameClient{
	public static void main(String args[]){
		Socket server=null;
		try{
			server=new Socket("localhost",8888);
			Reader reader=new Reader(server);
			Writer writer=new Writer(server);
			reader.start();
			writer.start();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

class Reader extends Thread{
	private Socket server;
	public Reader(Socket server){
		this.server=server;
	}
	public void run(){
		while(true){
			try{
				BufferedReader br=new BufferedReader(new InputStreamReader(server.getInputStream()));
				String msg=br.readLine();
				System.out.println(msg);
				//br.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

class Writer extends Thread{
	private Socket server;
	public Writer(Socket server){
		this.server=server;
	}
	public void run(){
		while(true){
			try{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String msg=br.readLine();
				PrintWriter pw=new PrintWriter(server.getOutputStream());
				pw.println(msg);
				//System.out.println(msg);
				pw.flush();
				//br.close();
				//pw.close();
			}catch(Exception e){}
		}
	}
}
