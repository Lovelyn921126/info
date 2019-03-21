package com.example.demo.main.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5899850575047766491L;
 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleNmae() {
		return roleNmae;
	}
	public void setRoleNmae(String roleNmae) {
		this.roleNmae = roleNmae;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Id
	private Long id;
	@Field("role_name")
	private String roleNmae;
	@Field("note")
	private String note;
}
