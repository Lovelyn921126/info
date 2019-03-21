package com.example.demo.main.menu;

import com.example.demo.main.pojo.User;

import lombok.Data;


public enum SexEnum {
    
	MALE(1,"男"),FEMALE(2,"女");
	
	
	private int code;
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	private SexEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static SexEnum getSexMenu(int code) {
		SexEnum[] sexEnums=SexEnum.values();
		for (SexEnum sexEnum : sexEnums) {
			if (sexEnum.getCode()==code) {
				return sexEnum;
			}
		}
		return null;
	}
}
