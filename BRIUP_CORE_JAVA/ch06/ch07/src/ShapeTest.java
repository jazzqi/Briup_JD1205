package com.briup.ch07;

public class ShapeTest{
	public static void main(String args[]){
		Shape s1=new Circle(5,1,1);
		Shape s2=new Rectangle(1,1,5,5);
		
		Canvas c=new Canvas();
		s1.draw(c);
		s2.draw(c);
	}
}
