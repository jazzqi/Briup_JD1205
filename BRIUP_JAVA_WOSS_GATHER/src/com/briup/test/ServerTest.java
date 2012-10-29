package com.briup.test;

import java.util.Collection;

import com.briup.util.BIDR;
import com.briup.util.Configuration;
import com.briup.util.ConfigurationImpl;
import com.briup.woss.server.DBStoreImpl;
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
			Collection<BIDR> info = s.revicer();
			System.out.println(info.size());
			// 开启一个新的DBStore线程对数据进行持久化
			DBStoreImpl d= (DBStoreImpl) c.getDBStore();
			//d.saveToDB(info);
			d.setRecordList(info);
			d.start();
		}
	}

}
