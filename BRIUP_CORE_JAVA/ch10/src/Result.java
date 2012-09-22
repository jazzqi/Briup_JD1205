package com.briup.ch10;

public class Result{
	private int value;
	private boolean isOver=false;
	public void setValue(int value){
		this.value=value;
		isOver=true;
	}
	public int getValue(){
		int v=value;
		return v;
	}
	public boolean getIsOver(){
		boolean flag=isOver;
		return flag;
	}
	public void setIsOver(boolean isOver){
		this.isOver=isOver;
	}
}
