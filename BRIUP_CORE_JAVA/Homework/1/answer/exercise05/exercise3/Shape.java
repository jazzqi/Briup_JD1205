package com.qifei.homework;

public class Shape{
	private int x,y;
	public Shape(){
		setX(10);
		setY(10);
	}
	public Shape(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void draw(){
		System.out.println("Shape draw");
	}

	public void setX(int x){
		this.x=x;
	}

	public void setY(int y){
		this.y=y;
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
}
