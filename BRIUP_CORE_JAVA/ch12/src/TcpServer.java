package com.briup.ch12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TcpServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket client = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		
		try {
			//构建服务器端，并监听
			server = new ServerSocket(8888);
			while(true){
				//获取Scoket
				client = server.accept();
				System.out.println("===============");
				br = new BufferedReader(new InputStreamReader
						(client.getInputStream()));
				String msg = br.readLine();
				System.out.println(msg+" "+
				client.getInetAddress().getHostAddress());
				
				Thread.sleep(8000);
				pw = new PrintWriter(client.getOutputStream());
				pw.println("now is:"+new Date());
				pw.flush();
				
				client.close();
				br.close();
				pw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
