package com.briup.ch12;

import java.io.*;
import java.net.*;

public class NumGameServer{
	public static void main(String args[]){
		ServerSocket server=null;
		Socket client=null;
		try{
			server=new ServerSocket(8888);
			while(true){
				client=server.accept();
				new GameThread(client).start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

class GameThread extends Thread{
	private Socket client;
	public GameThread(Socket client){
		this.client=client;
	}
	public void run(){
		BufferedReader br=null;
		PrintWriter pw=null;
		boolean flag=true;
		int goal=(int)(Math.random()*100);
		while(flag){
			try{
				br=new BufferedReader(new InputStreamReader(client.getInputStream()));
				pw=new PrintWriter(client.getOutputStream());
				for(int i=0;i<10&&flag;i++){
					int answer=Integer.parseInt(br.readLine());
					if(answer>goal){
						pw.println(answer+">"+goal);
						pw.flush();
						if(i==9){
							pw.println("You have tried 10 times, but all failed. You lose! ");
							pw.flush();
						}
					}else if(answer<goal){
						pw.println(answer+"<"+goal);
						pw.flush();
						if(i==9){
							pw.println("You have tried 10 times, but all failed. You lose! ");
							pw.flush();
						}
					}else if(answer==goal){
						pw.println("You Win");
						flag=false;
					}
					pw.flush();
				}	
			}catch(Exception e){
				flag=false;
				e.printStackTrace();
			}
		}
		pw.flush();
	}
}
