package com.example.demo.main.aop;

import com.example.demo.main.bean.User;

public class UserValidateImpl implements UserValidate {

	@Override
	public boolean validate(User user) {
		System.out.println("引入新的接口::"+UserValidateImpl.class.getSimpleName());
		return user!=null;
	}

}
