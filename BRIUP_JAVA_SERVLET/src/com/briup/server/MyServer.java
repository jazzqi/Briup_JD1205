package com.briup.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyServer extends Thread {
	private Socket s;
	private InputStream in;
	private PrintStream out;
	private String path = "var/";

	public MyServer(Socket s) {
		this.s = s;
		try {
			in = s.getInputStream();
			out = new PrintStream(s.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void run() {
		try {
			String resource = parse(in);
			sendMessage(resource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendMessage(String resource) throws Exception {
		File file=new File(path+resource);
		System.out.println(path+resource);
		if(!file.exists()){
			sendError("404","The page is not found!");
		}else{
			InputStream is=new FileInputStream(file);
			byte[] data=new byte[(int) file.length()];
			is.read(data);
			out.println("Http/1.1 200 OK");
			out.println("content-type: text/html");
			out.println();
			out.write(data);
			out.flush();
			out.close();
		}
	}

	private void sendError(String errorCode, String errorMessage) {
		// TODO Auto-generated method stub
		out.println("Http/1.1 "+errorCode+" "+errorMessage+"");
		out.println("content-type: text/html");
		out.println();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Sorry, the Page is Not Found");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>");
		out.println(errorCode);
		out.println("</h1>");
		out.println("<hr />");
		out.println("<h2>");
		out.println(errorMessage);
		out.println("</h2>");
		out.println("</body>");
		out.println("<>");
		out.flush();
		out.close();
	}

	private String parse(InputStream in) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String buff=br.readLine();
		//while(null!=(buff=br.readLine())){
		String str[]=buff.split(" ");
		for(String s:str){
			System.out.print(s+"|");
		}
		return str[1];
	}

}
