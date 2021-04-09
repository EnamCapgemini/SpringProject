package com.cg.mts.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommiteeLogin implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String password;

	public CommiteeLogin() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
