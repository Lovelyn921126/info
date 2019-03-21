package com.example.demo.main.intercept;

public class Test {
  public static void main(String[] args) {
	HellowService hellowService=new HellowServiceImpl();
	HellowService proxyBena=(HellowService) ProxyBean.getProxyBean(hellowService, new MyInterceptor());
	proxyBena.sayHellow("lyn");
	
}
}
