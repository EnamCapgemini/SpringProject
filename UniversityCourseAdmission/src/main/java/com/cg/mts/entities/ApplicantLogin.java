package com.cg.mts.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class ApplicantLogin implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String password;
	
	public ApplicantLogin() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
