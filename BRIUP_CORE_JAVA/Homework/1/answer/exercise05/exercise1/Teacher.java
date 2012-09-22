package com.md05;

public class Teacher
{
	private String name;		
 	private  int age;		
	private double salary;


	public void increaseAge(){
		age++;
	}
		
		
	public Teacher(String name,int age,double salary)
	{
	  this.name=name;
	  this.age=age;
	  this.salary=salary;
	}
	
	public Teacher(){}
	
	public void setName(String name)
	{
	 this.name=name;
	}
	public String getName()
	{
	 return name;
	}
    	public void setAge(int age)
    {
      this.age=age;
    }
	public int getAge()
    {
   	  return age;
    }
  	public void setSalary(double salary)
  	{
  	 this.salary=salary;
  	}
  	public double getSalary()
  	{
  	 return salary;
  	}

	public String toString()
	{
	return "name="+name+"age="+age+"salary="+salary;
	}
}
