package com.briup.ch12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GuessNumberServer extends Thread{
	private BufferedReader br = null;
	private PrintWriter pw = null;
	private Socket socket;
	public GuessNumberServer(Socket socket){
		try {
			this.socket = socket;
			br = new BufferedReader(new InputStreamReader
					(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		GuessNumber guess = new GuessNumber();
		guess.setNum(Math.round((float)Math.random()*100));
		while(true){
			guess.setNumGuesses(guess.getNumGuesses()+1);
			pw.println("I think the number is 0 between 100:");
			pw.flush();
			try {
				Thread.sleep(500);
				String answer = br.readLine();
				guess.setAnswer(answer);
				int guessNum = Integer.parseInt
				(answer.trim());
				if(guessNum==guess.getNum()){
					guess.setSuccess(true);
					pw.println("Conratulation!you got the num.And only " +
					+guess.getNumGuesses()+" tries!");
					pw.flush();
					pw.println("Are you try again:y/n");
					pw.flush();
					// 是否进行下一次
					String isGo = br.readLine().trim();
					if("y".equals(isGo)){
						guess = new GuessNumber();
						guess.setNum(Math.round((float)Math.random()*100));
						continue;
					}else{
						pw.println("110");
						pw.flush();
						break;
					}
				}else if("110".equals(answer)){
					pw.println("110");
					pw.flush();
					break;
				}else{
					pw.println("good job! you are try "+
							guess.getNumGuesses()+" times!");
					guess.setHint();
					pw.println("But the number you guess is too "+
					guess.getHint());
					pw.flush();
					continue;
				}
				
			} catch (NumberFormatException e) {
				continue;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			if(br!=null)br.close();
			if(pw!=null)pw.close();
			if(socket!=null)socket.close();
		} catch (Exception e) {}
	}
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket
			(Integer.parseInt(PropertiesUtils.
			properties.getProperty("port")));
			System.out.println("server is runing....");
			while(true){
				Socket socket = server.accept();
				new GuessNumberServer(socket).start();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
