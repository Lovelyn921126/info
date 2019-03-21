package com.example.demo.main.intercept;

import java.lang.reflect.InvocationTargetException;



public interface Intercept {
  
	public void before() ;
	public void after() ;
	/**\
	 * 取代原有方法
	 * @param invocation 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;
	//事后返回方法
	public void afterReturning() ;
	//事后异常方法
	public void afterExceprion() ;
	//是否使用round 方法
	public boolean useRound() ;
}
