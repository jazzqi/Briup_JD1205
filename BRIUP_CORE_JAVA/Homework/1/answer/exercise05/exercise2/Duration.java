package com.md05;

public class Duration{
	private int hours,minutes,seconds;

	public Duration(int hours,int minutes,int seconds){
		this.hours=hours;
		this.minutes=minutes;
		this.seconds=seconds;
	}

	public Duration(int totalSeconds){
		int seconds=totalSeconds%60;
		int minutes=totalSeconds/60;
		int hours=minutes/60;
		minutes%=60;

		this.hours=hours;
		this.minutes=minutes;
		this.seconds=seconds;
	}

	public int getTotalSeconds(){
		return hours*3600+minutes*60+seconds;
	}

	public String toString(){
		return hours+":"+minutes+":"+seconds;
	}

	public void setHours(int hours){
		this.hours=hours;
	}

	public void setMinutes(int minutes){
		this.minutes=minutes;
	}

	public void setSeconds(int seconds){
		this.seconds=seconds;
	}

	public int getHours(){
		return hours;
	}

	public int getMinutes(){
		return minutes;
	}

	public int getSeconds(){
		return seconds;
	}
}
