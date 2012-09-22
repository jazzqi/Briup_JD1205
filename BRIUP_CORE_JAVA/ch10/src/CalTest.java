package com.briup.ch10;

public class CalTest{
	public static void main(String args[]){
		Result res=new Result();
		CalResult crt=new CalResult(res);
		PrintResult prt=new PrintResult(res);
		crt.start();
		prt.start();

	}
}

class CalResult extends Thread{
	private Result res;
	public CalResult(Result res){
		this.res=res;
	}
	public void run(){
		int sum=0;
		for(int i=1;i<=100;i++)
			sum+=i;
		res.setValue(sum);
		synchronized(res){//Use three steps to keep synchronized execution
			if(res.getIsOver()==true)
				res.notifyAll();
		}
	}
}

class PrintResult extends Thread{
	private Result res;
	public PrintResult(Result res){
		this.res=res;
	}
	public void run(){
		synchronized(res){
			if(res.getIsOver()==false){
				try{
					res.wait();//will release the lock
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		int sum=res.getValue();
		System.out.println(sum);
	}
}
