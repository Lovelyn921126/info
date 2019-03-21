package com.ultrapower.dubbo.demo.provider;

import org.dubbo_demo.api.Service.User;
import org.dubbo_demo.api.Service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		 return new User(id, "username" + id);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
