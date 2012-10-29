package com.briup.bean;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class Address {
	private String post;
	private String number;
	private String street;
	private String city;
	private String province;
	private String country;
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Set getSet() {
		return set;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	private List list;
	private Set set;
	private Map map;
	private Properties prop;
	
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public void showCollection(){
		System.out.println("----------List---------");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		System.out.println("----------Set---------");
		for (Object o : set) {
			System.out.println(o);
		}
		System.out.println("----------Map---------");
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry en = (Entry) it.next();
			System.out.println(en.getKey()+":"+en.getValue());
		}
		System.out.println("----------Prop---------");
		for (Object str : prop.values()) {
			System.out.println(str.toString());
		}
	}

}
