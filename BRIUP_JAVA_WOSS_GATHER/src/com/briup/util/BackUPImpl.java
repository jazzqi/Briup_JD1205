package com.briup.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import org.junit.Test;

import com.briup.woss.ConfigurationAWare;

public class BackUPImpl implements BackUP, ConfigurationAWare {

	private ConfigurationImpl conf = null;
	private static Logger log = null;
	private String backupPath;

	@Override
	public void init(Properties p) {
		// TODO Auto-generated method stub
		backupPath = p.getProperty("BackupPath");
	
	}

	@Override
	public void setConfiguration(Configuration arg0) {
		// TODO Auto-generated method stub
		this.conf = (ConfigurationImpl) arg0;
		try {
			log = conf.getLogger();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	@Override
	public Object load(String key, boolean flag) throws Exception {
		// TODO Auto-generated method stub
		backupPath = "backup/" + key;
		log.info("Trying to load recover file:" + backupPath);
		File file = new File(backupPath);
		if (file.exists()) {
			Object o = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(file))).readObject();
			if (flag) {
				file.delete();
				log.debug("Delete backup file:" + backupPath);
			}
			log.info("Finish load recover file");
			return o;
		} else
			return null;
	}

	@Override
	public void store(String key, Object data, boolean flag) throws Exception {
		// TODO Auto-generated method stub
		log.info("Trying to store recover file:" + key);
		backupPath = "backup/" + key;
		File f=new File(backupPath);
		if(!f.exists())
			f.createNewFile();
		ObjectOutputStream oo = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(backupPath, flag)));
		oo.writeObject(data);
		oo.flush();
		oo.close();
		log.info("Finish store");
	}

	@Test
	public void delete(){
		File f=new File("backup/client.bak");
		f.delete();
	}
}
