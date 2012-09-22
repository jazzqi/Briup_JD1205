package com.qifei.orm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qifei.orm.dao.EmployeeDao;
import com.qifei.orm.pojo.Employee;
import com.qifei.util.ConnectionFactory;
import com.qifei.util.JDBCTemplate;
import com.qifei.util.ResultSetHandler;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee findEmpById(long id) {
		// TODO Auto-generated method stub
		String sql="select id,last_name,title,salary from s_emp where id=?";
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs=null;
		try {
			conn=ConnectionFactory.getConnection();
			pstat=conn.prepareStatement(sql);
			pstat.setLong(1, id);
			rs=pstat.executeQuery();
			Employee e=new Employee();
			while(rs.next()){
				e.setId(rs.getLong(1));
				e.setLast_name(rs.getString(2));
				e.setTitle(rs.getString(3));
				e.setSalary(rs.getDouble(4));
			}
			return e;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		//return null;
	}

	@Override
	public List<Employee> findAllEmp() {
		// TODO Auto-generated method stub
		JDBCTemplate template=new JDBCTemplate();
		final List<Employee> emps=new ArrayList<Employee>(); 
		template.query("select id,last_name,title,salary from s_emp", new ResultSetHandler(){

			@Override
			public void process(ResultSet rs) {
				// TODO Auto-generated method stub
				try {
					while(rs.next()){
						Employee e=new Employee();
						e.setId(rs.getLong(1));
						e.setLast_name(rs.getString(2));
						e.setTitle(rs.getString(3));
						e.setSalary(rs.getDouble(4));
						emps.add(e);
					}				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		return emps;
	}

	@Override
	public void modifyEmpById(Employee e) {
		// TODO Auto-generated method stub
		JDBCTemplate template = new JDBCTemplate();
		String sql="update s_emp set last_name='"+e.getLast_name()+"', title='"+e.getTitle()+"', salary="+e.getSalary()+" where id="+e.getId();
		template.update(sql);
	}

	@Override
	public void addEmp(Employee e) {
		// TODO Auto-generated method stub
		String sql = "insert into s_emp (id,last_name,salary,title) values (?,?,?,?)";
		// new JDBCTemplate().query(sql, handler);
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = ConnectionFactory.getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setLong(1, e.getId());
			pstat.setString(2, e.getLast_name());
			pstat.setDouble(3, e.getSalary());
			pstat.setString(4, e.getTitle());
			pstat.execute();
		} catch (Exception e2) {
			// TODO: handle exception
		} finally {
			ConnectionFactory.close(conn, pstat, null);
		}
	}

	public static void main(String args[]){
		EmployeeDao dao=new EmployeeDaoImpl();
		Employee e=new Employee(22222,"zhenlei","President",1);
		//Insert
		//dao.addEmp(e);
		//±éÀú
		List<Employee> emps=dao.findAllEmp();
		for (Employee employee : emps) {
			System.out.println(employee.getLast_name()+",");
		}	
		//modify Object
		e.setLast_name("Lei Zhen Mod");
		dao.modifyEmpById(e);
		//get Object by ID
		Employee ee=dao.findEmpById(22222);
		System.out.println(ee.getId()+":"+ee.getLast_name());

	}
}
