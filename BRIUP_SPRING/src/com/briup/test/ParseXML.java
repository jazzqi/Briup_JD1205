package com.briup.test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseXML {
	public static Map<String, Object> parse(String path)
			throws DocumentException, InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		// 保存解析XML时生成的bean集合
		Map<String, Object> map = new HashMap();
		//保存 需要注入的bean和相关参数
		Map<String, TempValue> map2 = new HashMap();
		
		//解析dom
		SAXReader reader = new SAXReader();
		File file = new File(path);
		Document doc = reader.read(file);
		Element rootElement = doc.getRootElement();
		List<Element> elements = rootElement.elements();
		
		// 遍历生成bean
		for (Element element : elements) {
			String name = element.attributeValue("name");
			String clazz = element.attributeValue("class");
			Object o = Class.forName(clazz).newInstance();
			map.put(name, o);

			//保存需要注入的bean
			List<Element> props = element.elements();
			for (Element prop : props) {
				map2.put(name, new TempValue(prop.attributeValue("name"),
						prop.attributeValue("ref")));
			}
		}
		// 遍历注入
		for (String name : map2.keySet()) {
			TempValue temp = map2.get(name);
			String methodName = convertName(temp.getName());
			Object o = map.get(name);
			Object oo = map.get(temp.getRef());
			Method method = o.getClass().getMethod(methodName, oo.getClass());
			method.invoke(o, oo);
		}
		return map;
	}

	public static String convertName(String name) {
		return "set" + name.substring(0, 1).toUpperCase()
				+ name.substring(1, name.length());
	}

}
