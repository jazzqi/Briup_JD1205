package com.md04;

public class Classroom  
{
	public Teacher teacher;						//保存教师	
	public Student[] students = new Student[40];//保存学生
	public int index = 0;						//保存学生数量

	public Teacher getTeacher(){
		//返回教室中的教师
		return teacher;
	}

	public Student[] getStudents(){
		//返回所有的学生
		return students
	}

	public void setTeacher(Teacher tea){
		//更换教师
		this.teacher=tea;
	}

	public void addStudent(Student stu){
		//增加学生
		if(index>=students.length){
			Student[] ns=new Student[student.length+1];
			System.arraycopy(students,0,ns,0,student.length);
			students=ns;
			students[index++]=stu;
		}else
			students[index++]=stu;
	}

	public boolean removeStudent(int idx){
		//删除学生
		if(idx<index&&idx>=0){
			for(int i=idx;i<index-1;i++){
			students[i]=students[i+1];
			}
			return true;
		}else
			return false;
	}

	public int getStudentNum(){
		//返回教室中学生的数量
		return index;
	}

	public void print(){
		//输出当前教室中的教师和学生的信息
		teacher.print();
		for(int i=0;i<index;i++){
			students[i].print();
		}
	}
}
