package com.md05;

public class ShapeTest{
	public static void main(String[] args) {
		Shape[] s={new Shape(1,4), new Rectangle(1,2,3,4), new Circle(2,3,5)};
		for(int k = 0; k < s.length; k++){
			s[k].draw();
		}
	}
}
