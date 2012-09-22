package com.qifei.test;

public class Queue{
	int max_size;
	int val;
	int length;
	int[] que;

	public Queue(){
		max_size=9;
		val=0;
		que=new int[max_size];
		length=0;//que.length;
	}

	public void enQue(int i){
		if(length<max_size){
			que[length]=i;
			length++;
		}
	}

	public int deQue(){
		if(length>1){
			val=que[0];
			for(int i=1;i<=length-1;i++){
				que[i-1]=que[i];
			}
			length--;
		}else if(length==1){
			val=que[0];
			length--;
		}else 
			val=0;
		return val;
	}
	
	public static void main(String args[]){
		Queue q=new Queue();

		System.out.println("Joining in queue: ");

		/**Join in the queue*/
		for(int i=0;i<9;i++){
			q.enQue(i);
			System.out.print(i);
		}

		System.out.println("\nGetting out queue: ");

		/**Get out of the queue*/
		for(int i=0;i<9;i++){
			System.out.print(q.deQue());
		}

		System.out.println();
	}
}
