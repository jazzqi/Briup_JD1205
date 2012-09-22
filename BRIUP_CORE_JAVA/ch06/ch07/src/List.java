package com.briup.ch07;

public interface List{
	public void insert(int index,Object s);
	public void addHead(Object s);
	public void addTail(Object s);
	public void remove(int index);
	public void rmHead();
	public void rmTail();
	public void set(int index,Object s);
	public void setHead(Object s);
	public void setTail(Object s);
	public Object get(int index);
	public Object getHead();
	public Object getTail();
}
