package com.briup.ch03;

public class RunYearTest{
	public int displayDayNum(int year,int month){
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			return 31;
		}else if(month==2){
			if(year%4==0){
				if(year%100!=0){
					return 29;
				}else{
					if(year%400==0){
						return 29;
					}else{
						return 28;
					}
				}
			}else{
				return 28;
			}
		}else{
			return 30;
		}
	}
	public static void main(String[] args){
		RunYearTest t = new RunYearTest();
		int days = t.displayDayNum(2010,2);
		System.out.println(days);
	}
}
