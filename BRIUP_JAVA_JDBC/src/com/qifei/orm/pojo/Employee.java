package com.qifei.orm.pojo;

import java.sql.Date;

public class Employee {
	private long id;
	private String last_name;
	private String first_name;
//	private String userid;
//	private Date start_date;
//	private String comments;
//	private int manager_id;
	private String title;
//	private int dept_id;
	private double salary;
//	private double commission_pct;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(){}
	

	public Employee(long id, String last_name, String title,
			double salary) {
		super();
		this.id = id;
		this.last_name = last_name;
		//this.first_name = first_name;
		this.title = title;
		this.salary = salary;
	}
}
