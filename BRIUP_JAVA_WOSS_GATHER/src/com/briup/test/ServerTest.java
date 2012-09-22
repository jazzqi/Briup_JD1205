package com.briup.test;

import com.briup.util.Configuration;
import com.briup.util.ConfigurationImpl;
import com.briup.woss.server.DBStore;
import com.briup.woss.server.Server;

public class ServerTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("server start");
		Configuration c=new ConfigurationImpl();
		Server s=c.getServer();
		while(true){
			DBStore d=c.getDBStore();
			d.saveToDB(s.revicer());
			System.out.println(System.currentTimeMillis());
		}
	}

}
