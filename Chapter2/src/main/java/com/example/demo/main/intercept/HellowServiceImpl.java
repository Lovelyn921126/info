package com.example.demo.main.intercept;

import org.springframework.stereotype.Service;

@Service
public class HellowServiceImpl implements HellowService {

	@Override
	public void sayHellow(String name) {
		if (name==null||name.trim()=="") {
			throw new RuntimeException("parames is null");
		}
		System.out.println("Hellow "+name);
 
	}

}
