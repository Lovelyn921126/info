package com.example.demo.main.intercept;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {
	private Intercept intercept = null;
	private Object target = null;

	public static Object getProxyBean(Object target, Intercept intercept) {
		ProxyBean proxyBean = new ProxyBean();
		proxyBean.target = target;
		proxyBean.intercept = intercept;
		Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				proxyBean);
		return proxy;
	}

	public Intercept getIntercept() {
		return intercept;
	}

	public void setIntercept(Intercept intercept) {
		this.intercept = intercept;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] parames) throws Throwable {
		boolean exceptionFlag = false;
		Invocation invocation = new Invocation(parames, method, target);
		Object retObj = null;
		try {
			this.intercept.before();
			if (this.intercept.useRound()) {
				retObj = this.intercept.around(invocation);
			} else {
				retObj = method.invoke(target, parames);
			}
		} catch (Exception e) {
			exceptionFlag = true;
		}
		this.intercept.after();
		if (exceptionFlag) {
          this.intercept.afterExceprion();
		} else {
			 this.intercept.afterReturning();
			// return object;
		}
		return null;
	}

}
