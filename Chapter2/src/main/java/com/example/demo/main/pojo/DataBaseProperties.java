package com.example.demo.main.pojo;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jdbc")
public class DataBaseProperties {
    
	
	private String driverName;
	
	private String test;
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	private String url;
	private String userName;
	private String passWord;
	public String getDriverName() {
		return driverName;
	}
	//@Value("${datebase.url}")
	public void setDriverName(String driverName) {
		System.out.println("driverName="+driverName);
		this.driverName = driverName;
	}
	public String getUrl() {
		
		return url;
	}
	//@Value("${server.port}")
	public void setUrl(String url) {
		System.out.println("url="+url);
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	//@Value("${datebase.passWord}")
	public void setUserName(String userName) {
		System.out.println("userName="+userName);
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	//@Value("${datebase.password}")
	public void setPassWord(String passWord) {
		System.out.println("passWord="+passWord);
		this.passWord = passWord;
	}
  /* @Bean(name="dataSource",destroyMethod="close")
	public DataSource getDataSource(@Value("${driverName}")String driverName,@Value("${url}")String url,@Value("${url}")String userName,@Value("${url}")String passWord) {
		Properties properties=new Properties();
		properties.setProperty("driver", driverName);
		properties.setProperty("url", url);
		properties.setProperty("username", userName);
		properties.setProperty("password", passWord);
		DataSource dataSource=null;
		try {
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/

	
}
