package com.qifei.homework;

public class Circle extends Shape{
	private double r;

	public Circle(){
		r=1.0d;
	}

	public Circle(double r){
		this(r,5,5);
	}

	public Circle(double r,int x,int y){
		this.r=1.0d;
		super.setX(x);
		super.setY(y);
	}

	public void draw(){
		System.out.println("draw in circle, x="+getX()+"\ty="+getY()+"\tr="+getR());
	}

	public void setR(double r){
		this.r=r;
	}

	public double getR(){
		return r;
	}
}
