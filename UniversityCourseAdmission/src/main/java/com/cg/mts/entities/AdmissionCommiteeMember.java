package com.cg.mts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "AdmissionCommiteeMember")
public class AdmissionCommiteeMember {

	@Id
	@Column(name = "adminId")
	private int adminId;

	@NotEmpty(message = "Name must be to given")
	@NotNull(message = "Name is required")
	@Length(min = 5, max = 20, message = "Name not between 5-20 letters")
	@Column(name = "adminName")
	private String adminName;

	@NotEmpty(message = "Contact must be to given")
	@NotNull(message = "Contact is required")
	@Length(min = 2, max = 50, message = "Contact invalid")
	@Column(name = "adminContact")
	private String adminContact;

	public AdmissionCommiteeMember() {
		super();
	}

	public AdmissionCommiteeMember(int adminId, String adminName, String adminContact) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
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
