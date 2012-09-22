package com.md05;

public class Teacher
{
	private String name;		//姓名
 	private  int age;			//年龄
	private double salary;	//薪水

	//用于年龄增加的方法
	public void increaseAge(){
		age++;
	}
		
		
	public Teacher(String name,int age,double salary)
	{
	  this.name=name;
	  this.age=age;
	  this.salary=salary;
	}
	
	
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

	public String tostring()
	{
	return "name="+name+"age="+age+"salary="+salary;
	}
}
