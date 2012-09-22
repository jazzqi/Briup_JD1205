package com.briup.ch07;

public class ArrayList implements List{
	private Object[] list;
	private int count;

	public ArrayList(int maxsize){
		list=new Object[maxsize];
		count=0;
	}

	/**Decide whether to add space.*/
	public void addSpace(){
		if(count>=list.length){
			Object[] tmp=new Object[list.length+5];
			System.arraycopy(list,0,tmp,0,list.length);
			list=tmp;
		}
	}

	public void insert(int index,Object s){
		if(index<count&&index>=0){
			addSpace();
			for(int i=count;i>index;i--){
				list[i]=list[i-1];
			}
			list[index]=s;
			count++;
		}
	}

	public void addHead(Object s){
		insert(0,s);
		//if(count>=list.length)
			//addSpace();
		//for(int i=count;i>=0;i--){
			//list[i]=list[i-1];
		//}
		//list[0]=s;
		//count++;
	}

	public void addTail(Object s){
		insert(count,s);
		//addSpace();
		//list[count++]=s;
	}

	public void remove(int index){
		if(index>=0&&index<count){
			for(int i=index;i<count-1;i++){
				list[i]=list[i+1];
			}
			list[count-1]=null;
			count--;
		}
	}

	public void rmHead(){
		remove(0);
		//if(count>=1){
			//for(int i=0;i<count-1;i++){
				//list[i]=list[i+1];
			//}
			//list[--count]=null;
		//}
	}

	public void rmTail(){
		remove(count-1);
		//if(count>=1){
			//count--;
			//list[--count]=null;
		//}
	}

	public void set(int index,Object s){
		if(index>=0&&index<count)
			list[index]=s;
	}

	public void setHead(Object s){
		set(0,s);
		//if(count>0){
			//list[0]=s;
		//}
	}

	public void setTail(Object s){
		set(count-1,s);
		//if(count>0){
			//list[count-1]=s;
		//}
	}

	public Object get(int index){
		if(index>=0&&index<count)
			return list[index];
		else
			return null;
	}

	public Object getHead(){
		return get(0);
		//if(count>0)
			//return list[0];
		//else
			//return null;
	}

	public Object getTail(){
		return get(count-1);
		//if(count>0)
			//return list[count-1];
		//else
			//return null;
	}
}
