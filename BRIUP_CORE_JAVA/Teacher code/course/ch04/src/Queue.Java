package com.briup.ch04;

public class Queue{
	//队列的最大长度
	int max_size;
	//队列的计数长度
	int length;
	//队列的值 模拟的时候用1，2...
	int val;
	//队列操作的数组
	int[] que;

	public Queue(){
		max_size = 5;
		val = 1;
		que = new int[max_size];
		length = que.length;
	}
	public void createQue(){
		for(int i=0;i<length;i++){
			que[i] = val++;
		}
	}
	public void enQue(){
		if(length>=max_size){
			int[] tmp = new int[++max_size];
			System.arraycopy(que,0,tmp,0,que.length);
			length++;
			que = tmp;
			que[length-1] = val++;
		}else{
			que[length++] = val++;
		}
	}
	public void deQue(){
		if(length==0){
			System.out.println("nothing!");
		}
		else{
			for(int i=0;i<length-1;i++){
				que[i] = que[i+1];
			}
		length--;
		}
	}
	public void show(){
		for(int i=0;i<length;i++){
			System.out.println(que[i]);
		}
	}
	public static void main(String[] args){
		Queue q = new Queue();
		q.createQue();
		q.deQue();
		q.deQue();
		q.deQue();
		q.enQue();
		q.enQue();
		q.enQue();
		q.enQue();
		q.show();
	}
}
