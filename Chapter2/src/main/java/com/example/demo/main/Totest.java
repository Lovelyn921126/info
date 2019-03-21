package com.example.demo.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.main.bean.User;
import com.example.demo.main.demo.AppConfig;
import com.example.demo.main.pojo.BussinessPersion;
import com.example.demo.main.pojo.Person;

public class Totest {
   public static void main(String[] args) {
	ApplicationContext aContext=new AnnotationConfigApplicationContext(AppConfig.class);
//User user=	aContext.getBean(User.class);
//System.out.println(user.getId());
	Person person=aContext.getBean(BussinessPersion.class);
	person.service();
}
}
