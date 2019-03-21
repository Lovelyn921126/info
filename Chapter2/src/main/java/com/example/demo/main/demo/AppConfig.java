package com.example.demo.main.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;


@Configuration
//@ComponentScan(basePackageClasses= {User.class})
@ComponentScan("com.example.demo.main.*")
//@ComponentScan(basePackages="com.example.demo.main.*",lazyInit=true)
public class AppConfig {

	/*@Bean(name="user")
	public User initUser()
	{
		User user=new  User();
		user.setId(1);
		
		user.setUserName("user_name_1");
	
		user.setNote("note_1");
	return user;
	}*/
}
