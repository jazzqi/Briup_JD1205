package com.briup.ch12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GuessNumberClient {
	private BufferedReader br;
	private PrintWriter pw;
	
	public GuessNumberClient(Socket socket) {
		try {
			// 表示从服务器段接受数据
			br = new BufferedReader(new InputStreamReader
					(socket.getInputStream()));
			// 表示向服务器发送数据
			pw = new PrintWriter(socket.getOutputStream());
			Reader reader = new Reader();
			Writer writer = new Writer();
			reader.start();
			writer.start();
			
			reader.join();
			writer.join();
			
			socket.close();
			pw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public class Writer extends Thread{
		public void run(){
			while(true){
				BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
				try{
					Thread.sleep(500);
					String msg = br.readLine();
					if(msg!=null){
						if("110".equals(msg)){
							pw.println(msg);
							pw.flush();
							break;
						}
						pw.println(msg);
						pw.flush();
					}else{
						continue;
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.exit(0);
		}
	}
	
	public class Reader extends Thread{
		public void run(){
			while(true){
				try {
					Thread.sleep(500);
					String msg = br.readLine();
					if("110".equals(msg))
						break;
					System.out.println(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.exit(0);
		}
	}
	
	public static void main(String[] args) throws Exception{
		String adddress = PropertiesUtils.properties.
				getProperty("address");
		int port = Integer.parseInt
		((String)PropertiesUtils.properties.get("port"));
		Socket client = new Socket(adddress,port);
		new GuessNumberClient(client);
	}
}
