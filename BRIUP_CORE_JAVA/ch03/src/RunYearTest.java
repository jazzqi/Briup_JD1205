package com.briup.ch03;

public class RunYearTest{
	public int displayDayNum(int year,int month){
		if(month==2)
		{
			if((year%4==0&&year%100!=0)||(year%400==0)){
				return 29;
			}
			else return 28;
		}
		else if(month==1||month==3||month==5||month==7||month==9)
			return 31;
		else
			return 30;
	}	

	public static void main(String args[]){
		RunYearTest t=new RunYearTest();
		int days=t.displayDayNum(1000,2);
		System.out.println(days);
	}
}
