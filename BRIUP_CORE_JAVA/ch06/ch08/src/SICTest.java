package com.briup.ch08;

public class SICTest{
	private int i;
	private static int j;

	public SICTest(int i){
		this.i=i;
		j++;
	}
	static class SIC{
		private String name;
		private int age;

		public SIC(String name){
			this.name=name;
		}
	}
}
