package com.briup.ch07;

public class Circle extends Shape{
	private double r;
	private int x,y;

	//public Circle(){
		//r=1.0d;
	//}

	//public Circle(double r){
		//this(r,5,5);
	//}

	public Circle(double r,int x,int y){
		this.r=r;
		this.x=x;
		this.y=y;
		//super.setX(x);
		//super.setY(y);
	}

	public void draw(Canvas c){
		c.show(this);
		//System.out.println("draw in circle, x="+getX()+"\ty="+getY()+"\tr="+getR());
	}

	public void setR(double r){
		this.r=r;
	}

	public double getR(){
		return r;
	}

	public void setX(int x){
		this.x=x;
	}

	public int getX(){
		return x;
	}

	public void setY(int y){
		this.y=y;
	}

	public int getY(){
		return y;
	}
}
