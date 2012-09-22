package com.briup.ch09;

public class EmotionTest{
	public static void main(String args[]){
		final Girl mm1=new Girl();
		final Girl mm2=new Girl();
		final Girl other=new Girl();
		EmotionListener boyA=new EmotionListener(){
			public void processEmotion(EmotionEvent e){
				System.out.println("==============I am boyA============");
				Object source=e.getSource();
				if(source==mm){
					System.out.println("mm1 is "+e.getStatus()+"! I am "+e.getStatus()+" too! ");
				}else
					System.out.println("other mm! That's none of my bussiness!");
			}
		};
		EmotionListener boyB=new EmotionListener(){
			public void processEmotion(EmotionEvent e){
				System.out.println("==============I am boyB============");
				Object source=e.getSource();
				if(source==mm2){
					if(e.getStatus().equals("happy"))
						System.out.println("mm2 is happy! I am going to send her a flower! ");
					if(e.getSource().equals("sad"))
						System.out.println("mm2 is sad! I am going to tell her a funny story! ");
				}else
					System.out.println("other mm! That's none of my bussiness!");
			}
		};
		mm1.addBoySet(boyA);
		mm1.addBoySet(boyB);
		mm2.addBoySet(boyA);
		mm2.addBoySet(boyB);
		other.addBoySet(boyA);
		other.addBoySet(boyB);
		mm1.happy();
		mm1.sad();
		mm2.happy();
		mm2.sad();
		other.happy();
		other.sad();
	}
}
