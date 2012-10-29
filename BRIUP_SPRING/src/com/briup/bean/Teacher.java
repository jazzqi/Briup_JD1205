package com.briup.bean;

public class Teacher {
	private long id;
	private String name;
	private Student student;
	
	public void init(){
		System.out.println("in Teacher init()......");
	}
	
	public void destroy(){
		System.out.println("in Teacher destroy()......");
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher(long id, String name, Student student) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
	}
	public Teacher() {
		super();
	}
}
