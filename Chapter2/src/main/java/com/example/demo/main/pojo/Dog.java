package com.example.demo.main.pojo;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

	@Override
	public void use() {
		System.out.println("狗【"+Dog.class.getSigners()+"】是看门的");
		
	}

}
