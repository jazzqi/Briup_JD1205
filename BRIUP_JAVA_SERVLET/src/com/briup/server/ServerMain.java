package com.briup.server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	
	private Socket s;
	private ServerSocket ss;
	
	public static void main(String[] args) throws Exception{

		ServerMain sm=new ServerMain();
		sm.startServer();
	}
	private void startServer() throws Exception{
		
		ss = new ServerSocket(8781);
		System.out.println("Server is starting up, listening port is:8781");
		while(true){
			s=ss.accept();
			System.out.println("Connected!");
			MyServer ms=new MyServer(s);
			ms.start();
		}
		
	}

}
