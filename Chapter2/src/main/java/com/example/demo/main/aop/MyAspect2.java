package com.example.demo.main.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import com.example.demo.main.bean.User;



@Aspect
@Order(2)
public class MyAspect2 {
    
	@Pointcut("execution(* com.example.demo.main.bean..*.*(..))")
	public void point() {
		
	}
	@Pointcut("execution(* com.example.demo.main.aop.UserServiceImpl.printUser(..))")
	public void pointUser() {
		
	}
	@Before("pointUser()")
	public void before(JoinPoint joinPoint) {
		Object[] args=joinPoint.getArgs();
		System.out.println("MyAspec2 before.....");
	}
	//引入
	/*@DeclareParents(
			value="com.example.demo.main.intercept.HellowServiceImpl+",defaultImpl=UserValidateImpl.class)
	public UserValidate userValidate;*/

	@After("pointUser()")
	public void after() {
		// TODO Auto-generated method stub
		System.out.println("MyAspect2 after.....");
	}
	/*@Around("point()")
	public void round(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("around before.....");
		jp.proceed();
		System.out.println("around after.....");
	}*/


}
