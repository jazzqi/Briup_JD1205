package com.qifei.homework;

public class Rectangle extends Shape{
	private double height,width;

	public void setHeight(double height){
		this.height=height;
	}

	public void setWidth(double width){
		this.width=width;
	}

	public double getHeight(){
		return height;
	}

	public double getWidth(){
		return width;
	}

	public Rectangle(){
		setHeight(1.0d);
		setWidth(1.0d);
	}

	public Rectangle(double height,double width){
	}

	public Rectangle(int x,int y,double height,double width){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}

	public void draw(){
		System.out.println("draw in rectangle. x="+getX()+"\ty="+getY()+"\theight="+getHeight()+"\twidth="+getWidth());
	}
}
