package com.example.demo.main.pojo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cat implements Animal {

	@Override
	public void use() {
		System.out.println("猫【"+Cat.class.getSigners()+"】是看门的");
		
	}

}
