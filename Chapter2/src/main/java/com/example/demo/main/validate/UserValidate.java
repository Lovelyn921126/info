package com.example.demo.main.validate;



import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.main.bean.User;

public class UserValidate implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target==null) {
			errors.reject("", null, "用户不能为空");
		}
		User user=(User) target;
		if (StringUtils.isEmpty(user.getNote()) ) {
			errors.reject("", null, "用户备注不能为空");
		}
		
	}

	

}
