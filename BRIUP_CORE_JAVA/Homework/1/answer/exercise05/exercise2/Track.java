package com.md05;

public class Track{
	private String title;
	private Duration duration;

	public String toString(){
		return "my track title is:"+title+" duration is:"+duration;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public void setDuration(Duration duration){
		this.duration=duration;
	}

	public String getTitle(){
		return title;
	}

	public Duration getDuration(){
		return duration;
	}
}
