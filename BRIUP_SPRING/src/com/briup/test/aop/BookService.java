package com.briup.test.aop;

public class BookService implements IBookService {

	@Override
	public void save() {
		// TODO Auto-generated method stub

		System.out.println("save successful");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("delete successful");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("update successful");

	}

}
