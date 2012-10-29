package com.briup.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Member {
	private long id;
	private String name;
	private Order order;
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
	public Order getOrder() {
		return order;
	}
	//@Autowired建议写在set方法上面，也可以写在属性上
	//需要在xml文件中配置<context:annnotation-config>开启annotation
	//默认使用byType方式进行依赖注入
	//使用@Qualifier("order1")在方法的参数列表中order形参前，进行byName装配
	//@Autowired(required="false"), 如果找不到对应对象就不注入
	
	
	//@Resource先用byName再用byType的方式进行注入
	//@Resource(name="order1"),使用byName
	@Resource
	public void setOrder(Order order) {
		this.order = order;
	}
	

}
