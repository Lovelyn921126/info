package com.example.demo.main.intercept;

import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements Intercept {

	@Override
	public void before() {
		System.out.println("before.....");

		
		
	}

	@Override
	public void after() {
		// TODO Auto-generated method stub
		System.out.println("after.....");
	}

	@Override
	public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
		// TODO Auto-generated method stub
		System.out.println("around before.....");
		Object obj= invocation.process();
		System.out.println("around after.....");
		return obj;
	}

	@Override
	public void afterReturning() {
		// TODO Auto-generated method stub
		System.out.println("afterReturning.....");
	}

	@Override
	public void afterExceprion() {
		// TODO Auto-generated method stub
		System.out.println("afterExceprion.....");
	}

	@Override
	public boolean useRound() {
		// TODO Auto-generated method stub
		return true;
	}

}
