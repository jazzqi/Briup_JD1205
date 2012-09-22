package com.qifei.orm.dao;

import java.util.List;

import com.qifei.orm.pojo.Employee;

public interface EmployeeDao {
	Employee findEmpById(long id);
	
	List<Employee> findAllEmp();
	
	void modifyEmpById(Employee e);
	
	void addEmp(Employee e);
}
