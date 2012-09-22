package com.briup.ch04;

public class Queue{
	int max_size;
	int val;
	int length;
	int[] que;

	public Queue(){
		max_size=5;
		val=1;
		que=new int[max_size];
		//length=0;//que.length;
		length=que.length;
	}

	public void createQue(){
		for(int i=0;i<5;i++){
			que[i]=val++;
		}
	}
	public void enQue(){
		if(length>=max_size){
			int[] newque=new int[++max_size];
			System.arraycopy(que,0,newque,0,length);
			que=newque;
			que[length]=val++;
		}else
			que[length]=val++;
		length++;
	}

	public int deQue(){
		val=que[0];
		for(int i=1;i<=length-1;i++){
			que[i-1]=que[i];
		}
		/**if(length>1){
			val=que[0];
			for(int i=1;i<=length-1;i++){
				que[i-1]=que[i];
			}
		}else if(length==1){
			val=que[0];
		}else {
			val=0;
		}*/
		length--;
		return val;
	}
	
	public static void main(String args[]){
		Queue q=new Queue();
		q.createQue();

		q.enQue();
		q.enQue();
		q.deQue();
		q.deQue();
		q.deQue();
		q.deQue();
		//System.out.println("Joining in queue: ");

		/**Join in the queue*/
		//for(int i=0;i<3;i++){
		//	q.enQue();
		//	System.out.print(i);
		//}

		//System.out.println("\nGetting out queue: ");

		/**Get out of the queue*/
		int t=q.length;
		for(int i=0;i<t;i++){
			System.out.print(q.deQue());
		}

		System.out.println();
	}
}
