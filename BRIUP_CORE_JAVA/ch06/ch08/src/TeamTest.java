package com.briup.ch08;

public class TeamTest{
	class AgeComparator extends Comparator{
		public int compare(Student s1,Student s2){
		return s2.getAge()-s1.getAge();
		}
	}

	class MaxAndMin{
		private Student maxNameS;
		private Student maxAgeS;
		public MaxAndMin(Student MaxNameS,Student maxAgeS){
			this.maxNameS=maxNameS;
			this.maxAgeS=maxAgeS;
		}
	}

	public MaxAndMin getMaxAndMin(Team t){
		Student maxNameS=t.getMaxOrMin(
			new Comparator(){
				public int compare(Student s1,Student s2){
					return s1.getName().length()-s2.getName().length();
				}
			}
		);
		Student minAgeS=t.getMaxOrMin(
			new Comparator(){
				public int compare(Student s1,Student s2){
					return s1.getAge()-s2.getAge();
				}
			}
		);
		return new MaxAndMin(maxNameS,minAgeS);
	}
	
	public static void main(String args[]){
		class CodeComparator extends Comparator{
			public int compare(Student s1,Student s2){
				return s1.getCode()-s2.getCode();
			}
		}

		Student s1=new Student("zhangsan",18);
		Student s2=new Student("lisi",19);
		Student s3=new Student("wangwu",22);
		Student s4=new Student("zhangliu",19);

		TeamTest tt=new TeamTest();
		Team t=new Team(3);
		t.addStudent(s1);
		t.addStudent(s2);
		t.addStudent(s3);
		t.addStudent(s4);
		//t.showAllStudents();
		System.out.println("Min age:");
		//System.out.println(t.getMaxOrMin(new AgeComparator()).getAge());
		System.out.println(t.getMaxOrMin(tt.new AgeComparator()).getAge());
		System.out.println("Max code:");
		System.out.println(t.getMaxOrMin(new CodeComparator()).getCode());
		System.out.println("Max name:");
		System.out.println(t.getMaxOrMin(new Comparator(){
			public int compare(Student s1,Student s2){
				return s1.getName().length()-s2.getName().length();
			}
		}).getName());
		System.out.println("Max name:");
	//	System.out.println(t.getMaxOrMin(new Comparator(){
			
	}
}




