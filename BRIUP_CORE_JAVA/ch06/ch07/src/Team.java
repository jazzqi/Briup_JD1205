package com.briup.ch07;

public class Team{
	private Student[] s;
	private int count;

	public Team(int maxLength){
		s=new Student[maxLength];
		count=0;
	}

	public void addStudent(Student s1){
		if(count>=s.length){
			Student[] temp=new Student[s.length+1];
			System.arraycopy(s,0,temp,0,count);
			s=temp;
		}
		s[count++]=s1;
	}

	public void showAllStudents(){
		for(int i=0;i<count;i++)
			s[i].show();
	}

	public Student getStudent(int index){
		if(index>=0&&index<count){
			return s[index];
		}else return null;
	}

	//get max by code, get min by age
	public Student getMaxOrMin(Comparator c){//Compare logic was capsulated in the Comparator abstract class
		Student ss=s[0];
		for(int i=1;i<count;i++){
			if(c.compare(ss,s[i])<0){
				ss=s[i];
			}
		}
		return ss;
	}
}
