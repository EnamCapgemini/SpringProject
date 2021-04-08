package com.cg.mts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
public class AdmissionCommiteeMember {

	@Id
	@Column(name = "adminId")
	private int adminId;

	@NotNull(message = "Name is required")
	@Length(min = 5, max = 20, message = "name not between 5-20 letters")
	@Column(name = "adminName")
	private String adminName;
	@NotNull(message = "Contact is required")
	@Column(name = "adminContact")
	private String adminContact;

	public AdmissionCommiteeMember() {
		super();
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

}
