package com.example.demo.main.bean;

import org.springframework.stereotype.Service;

import com.example.demo.main.intercept.HellowService;

@Service
public class MyHellowServiceImpl implements HellowService {

	@Override
	public void sayHellow(String name) {
		if (name==null||name.trim()=="") {
			throw new RuntimeException("parames is null");
		}
		System.out.println("Hellow "+name);
 
	}

}
