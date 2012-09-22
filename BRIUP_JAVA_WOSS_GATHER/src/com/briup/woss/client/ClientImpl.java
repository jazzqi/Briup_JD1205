package com.briup.woss.client;

import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import com.briup.util.BIDR;
import com.briup.util.BackUP;
import com.briup.util.Configuration;
import com.briup.util.ConfigurationImpl;
import com.briup.util.Logger;
import com.briup.woss.ConfigurationAWare;

public class ClientImpl implements Client, ConfigurationAWare {

	private ConfigurationImpl conf = null;
	private static Logger log = null;
	private String ip;
	private int port;
	private String backupFileName;

	@Override
	public void init(Properties p) {
		// TODO Auto-generated method stub
		port = Integer.parseInt(p.getProperty("Port"));
		ip = p.getProperty("Server_IP");
		backupFileName = p.getProperty("ClientBackupFileName");
		try {
			log = conf.getLogger();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 尝试先发送备份文件,如果存在备份文件的话
		restore(backupFileName);
	}

	@Override
	public void setConfiguration(Configuration arg0) {
		// TODO Auto-generated method stub
		this.conf = (ConfigurationImpl) arg0;
	}

	@Override
	public void send(Collection<BIDR> list) throws Exception {
		// TODO Auto-generated method stub
		Socket so = null;
		ObjectOutputStream oo = null;
		try {
			so = new Socket(ip, port);
			log.debug("client builds socket:" + ip + ":" + port);
			oo = new ObjectOutputStream(new BufferedOutputStream(
					so.getOutputStream()));
			// for (BIDR bidr : arg0) {
			// oo.writeObject(bidr);
			// }
			oo.writeObject(list);
			oo.flush();
		} catch (Exception e) {
			log.error(e.getMessage());
			conf.getBackup().store(backupFileName, list, BackUP.STORE_OVERRIDE);
		} finally {
			try {
				oo.close();
				so.close();
			} catch (Exception e1) {
			}
			log.debug("client closes socket");
		}
	}

	@SuppressWarnings("unchecked")
	public void restore(String filename) {
		try {
			List<BIDR> list = (List<BIDR>) conf.getBackup().load(filename,
					BackUP.LOAD_REMOVE);
			if (null != list) {
				log.debug("Client start to send the backup file");
				this.send(list);
				log.debug("Client finish to send the backup file");
			} else {
				log.debug("find no backup file");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e.getMessage());
		}
	}
}
