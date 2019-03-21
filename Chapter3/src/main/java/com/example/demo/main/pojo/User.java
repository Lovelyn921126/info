package com.example.demo.main.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.alibaba.fastjson.JSON;
import com.example.demo.main.menu.SexEnum;


import lombok.Data;

@Data
@Document
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5527780966016206313L;
	 
	@Id
	private long id;
	
	@Field("sex")
	private SexEnum sex;
	@Field("user_name")
	private String userName;
	@Field("note")
	private String note;
	
	public static void main(String[] args) {
		User newUser = new User();
		newUser.setId(2L);
		newUser.setNote("note_new");
		newUser.setUserName("user_name_new");
		newUser.setSex(SexEnum.MALE);

	System.out.println(JSON.toJSONString(newUser)	);
	}

}
