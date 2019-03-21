/*package com.example.demo.main.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class ValueDemo {
	//@Value("#{T(System).currentTimeMillis()}")
	private String str;
	@Value("#{1+2}")
	private int run; 
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public boolean isPiFlag() {
		return piFlag;
	}
	public void setPiFlag(boolean piFlag) {
		this.piFlag = piFlag;
	}
	public boolean isStrFlag() {
		return strFlag;
	}
	public void setStrFlag(boolean strFlag) {
		this.strFlag = strFlag;
	}
	public String getStrApp() {
		return strApp;
	}
	public void setStrApp(String strApp) {
		this.strApp = strApp;
	}
	public String getResultDesc() {
		return resultDesc;
	}
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
	@Value("#{dataBaseProperties.url.length()>100}")
	private boolean piFlag;
	@Value("#{dataBaseProperties.url eq  'str' }")
	private boolean strFlag;
	@Value("#{dataBaseProperties.url +'====srping'}")
	private String strApp;
	@Value("#{dataBaseProperties.url.length()>100?'大于':'小于'}")
	private String resultDesc;
	private String userName;
	public String getUserName() {
		return userName;
	}
	@Value("#{dataBaseProperties.url?.toUpperCase()}")
	public void setUserName(String userName) {
		System.out.println("userName::"+userName);
		System.out.println("piFlag::"+piFlag);
		System.out.println("run::"+run);
		
		System.out.println("strFlag::"+strFlag);
		System.out.println("strApp::"+strApp);
		System.out.println("resultDesc::"+resultDesc);
		this.userName = userName;
	}
	public String getStr() {
		return str;
	}
	 @Value("#{T(System).currentTimeMillis()}")
	public void setStr(String str) {
		System.out.println("str::"+str);
		this.str = str;
	}
}
*/