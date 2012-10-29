package com.briup.test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.DocumentException;

public class BeanFactory {

	private static Map<String, Object> map; 
	
	static{
		try {
			map = ParseXML.parse("src/com/briup/test/bean.xml");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalArgumentException
				| InvocationTargetException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Object getBean(String beanName){
		return map.get(beanName);
	}
}
