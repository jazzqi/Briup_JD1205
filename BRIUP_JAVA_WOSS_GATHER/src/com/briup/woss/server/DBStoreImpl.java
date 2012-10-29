package com.briup.woss.server;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import com.briup.util.BIDR;
import com.briup.util.BackUPImpl;
import com.briup.util.Configuration;
import com.briup.util.ConfigurationImpl;
import com.briup.util.Logger;
import com.briup.woss.ConfigurationAWare;

public class DBStoreImpl extends Thread implements DBStore, ConfigurationAWare {

	private Collection<BIDR> recordList;
	
	
	public Collection<BIDR> getRecordList() {
		return recordList;
	}

	public void setRecordList(Collection<BIDR> recordList) {
		this.recordList = recordList;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stud
		//对备份文件进行恢复
		this.restoreToDB(backupFileName);
		this.saveToDB(recordList);
	}

	private ConfigurationImpl conf = null;
	private static Logger log = null;
	private String driver;
	private String url;
	private String user;
	private String passwd;
	private String backupFileName;

	// 在配置模块初始化此模块时调用该方法，传入参数
	@Override
	public void init(Properties p) {
		// TODO Auto-generated method stub
		driver = p.getProperty("jdbcDriver");
		url = p.getProperty("jdbcUrl");
		user = p.getProperty("uname");
		passwd = p.getProperty("passwd");
		backupFileName=p.getProperty("ServerBackupFileName");
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

	@Override
	public void saveToDB(Collection<BIDR> list) {// throws Exception {
		// TODO Auto-generated method stub
		log.debug("Starting to save list to Database");
		Connection conn = null;
		int count[] = new int[31];
		PreparedStatement pstat[] = new PreparedStatement[31];
		// 建立数据库连接 设置手动事务控制 如果发生异常 备份数据
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
			conn.setAutoCommit(false);
			for (int i = 0; i < 31; i++) {
				String sql = "INSERT INTO T_DETAIL_"
						+ i
						+ " (AAA_LOGIN_NAME,LOGIN_IP,LOGIN_DATE,LOGOUT_DATE,NAS_IP,TIME_DURATION) VALUES (?,?,?,?,?,?)";
				pstat[i] = conn.prepareStatement(sql);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				conf.getBackup().store(backupFileName, list, true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				log.fatal(e1.getMessage());
			}
			log.error(e.getMessage());
		}

		// 手动控制 数据库事务 如果发生异常 备份数据 并回滚数据库
		try {
			for (BIDR bidr : list) {
				Date login_date = new Date(bidr.getLogin_date().getTime());
				Date logout_date = new Date(bidr.getLogout_date().getTime());
				Calendar c = Calendar.getInstance();
				c.setTime(login_date);
				int day = c.get(Calendar.DAY_OF_MONTH);
				pstat[day].setString(1, bidr.getAAA_login_name());
				pstat[day].setString(2, bidr.getLogin_ip());
				pstat[day].setDate(3, login_date);
				pstat[day].setDate(4, logout_date);
				pstat[day].setString(5, bidr.getNAS_ip());
				pstat[day].setLong(6, bidr.getTime_deration());
				pstat[day].addBatch();
				count[day]++;
				if (count[day] % 2000 == 0) {
					pstat[day].executeBatch();
					// conn.commit();
				}
				// System.out.println(bidr.getAAA_login_name()+"|"+bidr.getLogin_ip()+"|"+new
			}
			for (int i = 0; i < count.length; i++) {
				pstat[i].executeBatch();
				// log.debug(i + "|" + count[i]);
			}
			conn.commit();
			log.debug("Finish saving to Database");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				conf.getBackup().store(backupFileName, list, true);
				// 发生异常 回滚数据库
				conn.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.fatal(e1.getMessage());
			}
			log.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	public void restoreToDB(String filename) {
		try {
			List<BIDR> list = (List<BIDR>) conf.getBackup().load(filename,
					true);
			if (null != list) {
				this.saveToDB(list);
			} else{
				log.debug("find no backup file");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
	}
	
	//测试用
	public static void main(String args[]) {
		log.info("begin");
		DBStoreImpl d = new DBStoreImpl();
		ServerImpl s = new ServerImpl();
		// GatherImpl g = new GatherImpl();
		Collection<BIDR> l = null;
		try {
			l = s.revicer();
			// l o=g.gather();
			long l1 = System.currentTimeMillis();
			d.saveToDB(l);
			long l2 = System.currentTimeMillis();
			// new BackUPImpl().store("test", g.gather(), true);
			log.info("Saving to Database costs: " + (l2 - l1) + "ms");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			try {
				new BackUPImpl().store("testDBStore.bak", l, true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
				log.error(e.getMessage());
			}
			log.error(e.getMessage());
		} finally {
			ConfigurationImpl c = new ConfigurationImpl();
			try {
				c.getLogger().info("over");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// log.info("over");
		}
	}

}
