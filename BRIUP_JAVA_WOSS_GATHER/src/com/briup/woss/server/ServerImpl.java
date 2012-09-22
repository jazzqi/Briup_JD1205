package com.briup.woss.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import com.briup.util.BIDR;
import com.briup.util.Configuration;
import com.briup.util.ConfigurationImpl;
import com.briup.util.Logger;
import com.briup.woss.ConfigurationAWare;

public class ServerImpl implements Server, ConfigurationAWare {

	private ServerSocket ss = null;
	private Socket so = null;
	private ObjectInputStream oi = null;
	private ConfigurationImpl conf = null;
	private static Logger log = null;
	private int port;

	@Override
	public void init(Properties p) {
		// TODO Auto-generated method stub
		port=Integer.parseInt(p.getProperty("Port"));
	
	}

	@Override
	public void setConfiguration(Configuration arg0) {
		// TODO Auto-generated method stub
		this.conf = (ConfigurationImpl) arg0;
		try {
			log = conf.getLogger();
			ss = new ServerSocket(port);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<BIDR> revicer() throws Exception {
		// TODO Auto-generated method stub
		while (true) {
			so = ss.accept();
			log.info("Server accepts a new connection");
			oi = new ObjectInputStream(new BufferedInputStream(
					so.getInputStream()));
			// Object out;
			// while(null!=(out=oi.readObject())){
			// bidrList.add((BIDR)out);
			// System.out.println(((BIDR)out).getAAA_login_name());
			// }
			log.info("Server reads an List");
			List<BIDR> list = (List) oi.readObject();
			oi.close();
			so.close();
			return list;
		}
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		log.info("Server is shuting down");
		try {
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("Server shutdown exception, failed to close the stream"
					+ e.getMessage());
		}
	}
}
