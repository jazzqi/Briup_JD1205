package com.qifei.homework;

public class ShapeTest{
	public static void show(Shape s){
		s.draw();
	}
	public static void main(String args[]){
		Shape s=new Shape();
		Shape c=new Circle();
		Shape r=new Rectangle();
		
		show(s);
		show(c);
		show(r);
	}
}
