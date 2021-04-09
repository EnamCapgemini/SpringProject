package com.cg.mts.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "AdmissionCommiteeMember")
public class AdmissionCommiteeMember extends UniversityStaffMember implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ADMISSION_COMMITEE_MEMBER_ID")
	private int adminId;

	@NotEmpty(message = "Name must be to given")
	@NotNull(message = "Name is required")
	@Length(min = 5, max = 20, message = "Name not between 5-20 letters")
	@Column(name = "ADMISSION_COMMITEE_MEMBER_NAME")
	private String adminName;

	@NotEmpty(message = "Contact must be to given")
	@NotNull(message = "Contact is required")
	@Length(min = 2, max = 50, message = "Contact invalid")
	@Column(name = "ADMISSION_COMMITEE_MEMBER_CONTACT")
	private String adminContact;
	
	@OneToMany(mappedBy="admissioncommitee",cascade=CascadeType.ALL)
	private Set<Admission>  admission = new HashSet<>();
	

	
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

	public Set<Admission> getAdmission() {
		return admission;
	}

	public void setAdmission(Set<Admission> admission) {
		this.admission = admission;
	}
	

}
