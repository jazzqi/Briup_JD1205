package com.briup.ch07;

public class Rectangle extends Shape{
	private double height,width;
	private int x,y;

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

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public void setX(int x){
		this.x=x;
	}

	public void setY(int y){
		this.y=y;
	}

	public Rectangle(int x,int y,double height,double width){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}

	public void draw(Canvas c){
		c.show(this);
		//System.out.println("draw in rectangle. x="+getX()+"\ty="+getY()+"\theight="+getHeight()+"\twidth="+getWidth());
	}
}
