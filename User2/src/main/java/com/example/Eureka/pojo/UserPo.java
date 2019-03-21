package com.example.Eureka.pojo;

import java.io.Serializable;

public class UserPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1902540073553955262L;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	private Long id;
	private String userName;
	private int level;
	private String note;

}
