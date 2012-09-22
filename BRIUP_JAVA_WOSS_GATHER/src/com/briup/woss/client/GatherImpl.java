package com.briup.woss.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

import com.briup.util.BIDR;
import com.briup.util.BackUP;
import com.briup.util.Configuration;
import com.briup.util.ConfigurationImpl;
import com.briup.util.Logger;
import com.briup.woss.ConfigurationAWare;

public class GatherImpl implements Gather, ConfigurationAWare {

	private static Logger log;
	private String filePath;
	private String backPath;
	private ConfigurationImpl conf;
	private String NasIp;

	private long position = 0;
	private Map<String, BIDR> loginMap = new HashMap<>();
	private List<BIDR> recordList = new ArrayList<>();

	@Override
	public void init(Properties p) {
		// TODO Auto-generated method stub
		filePath = p.getProperty("RawDataFilePath");
		backPath = p.getProperty("GatherBackupFilePath");
		NasIp=p.getProperty("NAS_IP");
		
		// 尝试恢复
		restore(backPath);
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void restore(String s) {
		// TODO Auto-generated method stub
		try {
			Object o = conf.getBackup().load(s, BackUP.LOAD_REMOVE);
			if (null != o) {
				Map restoreMap = (Map) o;
				position = (long) restoreMap.get("postion");
				recordList = (List) restoreMap.get("list");
				loginMap = (Map) restoreMap.get("map");
			}else {
				log.debug("find no backup file");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
		}

	}

	@SuppressWarnings({ "resource", "unchecked", "rawtypes" })
	@Override
	public Collection<BIDR> gather() throws Exception {
		// TODO Auto-generated method stub
		log.debug("gather info begin");
		String s = "";
		String[] rec = null;
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(filePath)));
		//恢复上次读取到的位置
		br.skip(position);
		while (true) {
			try {
				if ((null != (s = br.readLine()))) {
					// System.out.println(s);
					rec = s.split("\\|");
					if ("7".equals(rec[2])) {
						// Login record
						BIDR bidr = new BIDR();
						bidr.setAAA_login_name(rec[0].substring(1));
						bidr.setLogin_date(new Timestamp(
								Long.parseLong(rec[3]) * 1000));
						bidr.setLogin_ip(rec[4]);
						bidr.setNAS_ip(NasIp);
						loginMap.put(rec[4], bidr);
					} else {// if("8".equals(rec[2])) {
							// Logout record
						BIDR bidr = loginMap.remove(rec[4]);
						Timestamp logout_time = new Timestamp(
								Long.parseLong(rec[3]) * 1000);
						Integer time_duration = (int) (Long.parseLong(rec[3]) - bidr
								.getLogin_date().getTime() / 1000);
						bidr.setLogout_date(logout_time);
						bidr.setTime_deration(time_duration);
						recordList.add(bidr);
					}
					//偏移量
					position+=s.getBytes().length+1;
				} else {
					log.debug("gather info finish, 总共："+position+"行");
					return recordList;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e.getMessage());
				Map bakMap = new HashMap();
				bakMap.put("list", recordList);
				bakMap.put("map", loginMap);
				bakMap.put("position", position);
				try {
					conf.getBackup().store(backPath, bakMap, true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					log.fatal(e1.getMessage());
				}
			}
		}
	}

	/**
	 * 使用RandomAccessFile访问文件，效率低
	 */
	@Test
	public void gatherTest() {
		RandomAccessFile rf = null;
		String filepath = "src/file/radwtmp";
		try {
			int pos = 0;
			boolean flag = true;
			String s = "";
			rf = new RandomAccessFile(new File(filepath), "r");
			String[] rec = null;
			Map<String, BIDR> loginMap = new HashMap<>();
			List<BIDR> recordList = new ArrayList<>();
			while (flag) {
				rf.seek(pos);
				for (int i = 0; i < 60000; i++) {
					if ((null != (s = rf.readLine()))) {
						pos += s.length() + 1;

						// if (abc == 0 || abc == 87325)
						// System.out.println(s);
						// abc++;

						rec = s.split("\\|");
						if ("7".equals(rec[2])) {
							// Login record
							BIDR bidr = new BIDR();
							bidr.setAAA_login_name(rec[0].substring(1));
							bidr.setLogin_date(new Timestamp(Long
									.parseLong(rec[3]) * 1000));
							bidr.setLogin_ip(rec[4]);
							bidr.setNAS_ip("127.0.0.1");
							loginMap.put(rec[4], bidr);
						} else {// if("8".equals(rec[2])) {
								// Logout record
							BIDR bidr = loginMap.remove(rec[4]);
							Timestamp logout_time = new Timestamp(
									Long.parseLong(rec[3]) * 1000);
							Integer time_duration = (int) (Long
									.parseLong(rec[3]) - bidr.getLogin_date()
									.getTime() / 1000);
							bidr.setLogout_date(logout_time);
							bidr.setTime_deration(time_duration);
							recordList.add(bidr);
						}

					} else {
						flag = false;
					}
				}
				// System.gc();
			}
			System.out.println(recordList.size());
			System.out.println(((BIDR) recordList.get(recordList.size() - 1))
					.getTime_deration());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
