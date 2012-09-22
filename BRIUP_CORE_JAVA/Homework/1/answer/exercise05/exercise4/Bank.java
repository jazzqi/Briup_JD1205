package com.qifei.homework;

public class Bank{
	private Customer[] customers;
	private int custNum;

	public Bank(){
		customers=new Customer[10];
		custNum=0;
	}

	public void addCustomer(Customer customer){
		if(custNum>=customers.length){
			Customer[] nc=new Customer[customers.length+1];
			System.arraycopy(customers,0,nc,0,customers.length);
			customers=nc;
		}
		customers[custNum++]=customer;
	}

	public Customer getCustomer(int index){
		return customers[index];
	}

	public int getCustomerNum(){
		return custNum;
	}
}
