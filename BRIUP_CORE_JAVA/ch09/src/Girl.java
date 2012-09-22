package com.briup.ch09;

import java.util.*;

public class Girl{
	private Set boySet=new HashSet();

	public Girl(){}

	public void addBoySet(EmotionListener boy){
		boySet.add(boy);
	}

	public void happy(){
		try{
			EmotionEvent e=new EmotionEvent(this);
			e.setStatus("happy");
			Iterator i=boySet.iterator();
			while(i.hasNext()){
				EmotionListener boy=(EmotionListener)i.next();
				boy.processEmotion(e);
			}
		}catch(EmotionException e){
			e.printStackTrace();
		}
	}

	public void sad(){
		try{
			EmotionEvent e=new EmotionEvent(this);
			e.setStatus("sad");
			Iterator i=boySet.iterator();
			while(i.hasNext()){
				EmotionListener boy=(EmotionListener)i.next();
				boy.processEmotion(e);
			}
		}catch(EmotionException e){
			e.printStackTrace();
		}
	}
}
