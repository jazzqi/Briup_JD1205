package com.briup.bean;

import org.springframework.stereotype.Component;

//@Component 使当前类成为spring管理的资源，默认的资源名为类名首字母小写
//也可以指定名字@Componnent("order2")
@Component
public class Order {
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
