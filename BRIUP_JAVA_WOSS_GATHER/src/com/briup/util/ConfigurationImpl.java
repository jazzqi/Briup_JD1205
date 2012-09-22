package com.briup.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.briup.woss.client.Client;
import com.briup.woss.client.Gather;
import com.briup.woss.server.DBStore;
import com.briup.woss.server.Server;

public class ConfigurationImpl implements Configuration {

	private static Properties properties=new Properties();
	
	static {
		try {
			properties.load(new BufferedInputStream(new FileInputStream("src/init.ini")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public BackUP getBackup() throws Exception {
		// TODO Auto-generated method stub
		return (BackUP)this.getBaseObject("com.briup.util.BackUPImpl");
	}

	@Override
	public Client getClient() throws Exception {
		// TODO Auto-generated method stub
		return (Client)this.getBaseObject("com.briup.woss.client.ClientImpl");
	}

	@Override
	public DBStore getDBStore() throws Exception {
		// TODO Auto-generated method stub
		return (DBStore)this.getBaseObject("com.briup.woss.server.DBStoreImpl");
	}

	@Override
	public Gather getGather() throws Exception {
		// TODO Auto-generated method stub
		return (Gather)this.getBaseObject("com.briup.woss.client.GatherImpl");
	}

	@Override
	public Logger getLogger() throws Exception {
		// TODO Auto-generated method stub
		return (Logger)this.getBaseObject("com.briup.util.LoggerImpl");
	}

	@Override
	public Server getServer() throws Exception {
		// TODO Auto-generated method stub
		return (Server)this.getBaseObject("com.briup.woss.server.ServerImpl");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object getBaseObject(String clazzName) throws Exception{
		Class clazz=Class.forName(clazzName);
		Object o=clazz.newInstance();
		//判断是否要调用setConfiguration()方法
		if(o instanceof com.briup.woss.ConfigurationAWare){
			Method m=clazz.getDeclaredMethod("setConfiguration", com.briup.util.Configuration.class);
			m.invoke(o, this);
		}		
		Method m = clazz.getMethod("init", Properties.class);
		//调用init()方法
		m.invoke(o, properties);
		return o;
	}
}
