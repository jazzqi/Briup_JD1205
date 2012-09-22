package com.briup.ch07;

public class Canvas{
	public void show(Circle c){
		System.out.println("draw circle : x="+c.getX()+" y="+c.getY()+" r="+c.getR());
	}

	public void show(Rectangle r){
		System.out.println("draw rectangle: x="+r.getX()+" y="+r.getY()+" width="+r.getWidth()+" length="+r.getHeight());
	}
}
