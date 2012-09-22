package com.md04;

public class Classroom  
{
	public Teacher teacher;						//�����ʦ	
	public Student[] students = new Student[40];//����ѧ��
	public int index = 0;						//����ѧ������

	public Teacher getTeacher(){
		//���ؽ����еĽ�ʦ
		return teacher;
	}

	public Student[] getStudents(){
		//�������е�ѧ��
		return students
	}

	public void setTeacher(Teacher tea){
		//������ʦ
		this.teacher=tea;
	}

	public void addStudent(Student stu){
		//����ѧ��
		if(index>=students.length){
			Student[] ns=new Student[student.length+1];
			System.arraycopy(students,0,ns,0,student.length);
			students=ns;
			students[index++]=stu;
		}else
			students[index++]=stu;
	}

	public boolean removeStudent(int idx){
		//ɾ��ѧ��
		if(idx<index&&idx>=0){
			for(int i=idx;i<index-1;i++){
			students[i]=students[i+1];
			}
			return true;
		}else
			return false;
	}

	public int getStudentNum(){
		//���ؽ�����ѧ��������
		return index;
	}

	public void print(){
		//�����ǰ�����еĽ�ʦ��ѧ������Ϣ
		teacher.print();
		for(int i=0;i<index;i++){
			students[i].print();
		}
	}
}
