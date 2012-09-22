package com.briup.ch11;

import java.io.*;

public class PipedTest{
	public static void main(String args[]) throws Exception{
		PipedInputStream pis=new PipedInputStream();
		PipedOutputStream pos=new PipedOutputStream(pis);
		Sender s=new Sender(pos);
		Print p=new Print(pis);
		s.start();
		p.start();
	}
}

class Sender extends Thread{
	private PipedOutputStream pos;
	public Sender(PipedOutputStream pos){
		this.pos=pos;
	}
	public void run(){
		DataOutputStream dos=null;
		try{
			dos=new DataOutputStream(pos);
			for(int i=1;i<=100;i++)
				dos.writeDouble(Math.random()*100);
			dos.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				dos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

class Print extends Thread{
	private PipedInputStream pis;
	public Print(PipedInputStream pis){
		this.pis=pis;
	}
	public void run(){
		DataInputStream dis=null;
		try{
			dis=new DataInputStream(pis);
			for(int i=1;i<=100;i++)
				System.out.println(dis.readDouble());
		}catch(Exception e){}
		finally{
			try{
				dis.close();
			}catch(Exception e){}
		}
	}
}
