package com.md04;

public class Classroom  
{
	public Teacher teacher;
	public Student[] students = new Student[40];
	public int index = 0;

	public Teacher getTeacher(){
		return teacher;
	}

	public Student[] getStudents(){
		return students;
	}

	public void setTeacher(Teacher tea){
		this.teacher=tea;
	}

	public void addStudent(Student stu){
		if(index>=students.length){
			Student[] ns=new Student[students.length+1];
			System.arraycopy(students,0,ns,0,students.length);
			students=ns;
			students[index++]=stu;
		}else
			students[index++]=stu;
	}

	public boolean removeStudent(int idx){
		if(idx<index&&idx>=0){
			for(int i=idx;i<index-1;i++){
			students[i]=students[i+1];
			}
			return true;
		}else
			return false;
	}

	public int getStudentNum(){
		return index;
	}

	public void print(){
		teacher.print();
		for(int i=0;i<index;i++){
			students[i].print();
		}
	}
}
