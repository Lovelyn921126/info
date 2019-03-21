package com.example.demo.main.intercept;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {
 

	private Object[] parames;
	private Method method;
	private Object target;
	public Invocation(Object[] parames, Method method, Object target) {
		this.parames = parames;
		this.method = method;
		this.target = target;
	}
	public Object process()throws InvocationTargetException,IllegalAccessException {
		return method.invoke(target, parames);
	}
	public Object[] getParames() {
		return parames;
	}
	public void setParames(Object[] parames) {
		this.parames = parames;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
}
