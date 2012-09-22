package com.briup.util;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

@SuppressWarnings("static-access")
public class LoggerImpl implements Logger {

	private org.apache.log4j.Logger myLog = org.apache.log4j.Logger
			.getLogger("myLog");

	static {
		PropertyConfigurator property = new PropertyConfigurator();
		property.configure("src/log4j.properties");
	}

	@Override
	public void init(Properties arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void debug(String arg0) {
		// TODO Auto-generated method stub
		myLog.debug(arg0);
	}

	@Override
	public void error(String arg0) {
		// TODO Auto-generated method stub
		myLog.error(arg0);
	}

	@Override
	public void fatal(String arg0) {
		// TODO Auto-generated method stub
		myLog.fatal(arg0);
	}

	@Override
	public void info(String arg0) {
		// TODO Auto-generated method stub
		myLog.info(arg0);
	}

	@Override
	public void warn(String arg0) {
		// TODO Auto-generated method stub
		myLog.warn(arg0);
	}

	public void init1(Properties arg0) {
		// TODO Auto-generated method stub
		
	}

}
