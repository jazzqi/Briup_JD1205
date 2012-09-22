package com.briup.ch09;

public class EmotionEvent{	
	private Object source;
	private String status;

	public EmotionEvent(Object source) throws EmotionException{
		setSource(source);
		//setStatus(status);
	}
	public void setSource(Object source) throws EmotionException{
		if(source == null)
			throw new EmotionException("source is null!");
		else
			this.source=source;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
	public Object getSource(){
		return source;
	}
}
