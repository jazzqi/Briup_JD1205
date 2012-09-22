package com.briup.test;

import com.briup.util.Configuration;
import com.briup.util.ConfigurationImpl;

public class ClientTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Configuration c=new ConfigurationImpl();
		System.out.println(System.currentTimeMillis());
		c.getClient().send(c.getGather().gather());
	}

}
