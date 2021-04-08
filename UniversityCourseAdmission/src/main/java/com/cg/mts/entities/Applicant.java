package com.cg.mts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "applicant")
public class Applicant {	
	@Id
	@Column(name = "APPLICANT_ID")
	private String applicantId;
	
	
	@NotEmpty(message="applicant name should not be empty")
	@NotNull(message="applicant name is required")
	@Length(min=4,max=15,message="${name.length.error}")
	private String applicantName;
	
	
	@NotEmpty(message="mobile number should not be empty")
	@NotNull(message="mobile number is required")
	@Length(min=10,max=10,message="${phone.length.error}")	
	private String mobileNumber;
	
	
	@NotEmpty(message="degree should not be empty")
	@NotNull(message="degree is required")
	@Length(min=3,max=10,message="${degree.length.error}")
	private String applicantDegree;
	
	
	@NotEmpty(message="percent should not be empty")
	@NotNull(message="percent is required")
	private int applicantGraduationPercent;
	
	private Admission admission;
	
	private AdmissionStatus status;
	
	
	@NotEmpty(message="gender should not be empty")
	private Gender gender;
	
	
	@NotEmpty(message="address should not be empty")
	private Address address;
	
	
	@NotEmpty(message="email should not be empty")
	@NotNull(message="email is required")
	@Email(message = "email should be valid")
	private String emailId;
	

	public Applicant() {
		
	}
	
	public Applicant(String applicantId,
			@NotEmpty(message = "applicant name should not be empty") @NotNull(message = "applicant name is required") @Length(min = 4, max = 15, message = "${name.length.error}") String applicantName,
			@NotEmpty(message = "mobile number should not be empty") @NotNull(message = "mobile number is required") @Length(min = 10, max = 10, message = "${phone.length.error}") String mobileNumber,
			@NotEmpty(message = "degree should not be empty") @NotNull(message = "degree is required") @Length(min = 3, max = 10, message = "${degree.length.error}") String applicantDegree,
			@NotEmpty(message = "percent should not be empty") @NotNull(message = "percent is required") int applicantGraduationPercent,
			Admission admission, AdmissionStatus status,
			@NotEmpty(message = "gender should not be empty") Gender gender,
			@NotEmpty(message = "address should not be empty") Address address,
			@NotEmpty(message = "email should not be empty") @NotNull(message = "email is required") @Email(message = "email should be valid") String emailId) {
		super();
		this.applicantId = applicantId;
		this.applicantName = applicantName;
		this.mobileNumber = mobileNumber;
		this.applicantDegree = applicantDegree;
		this.applicantGraduationPercent = applicantGraduationPercent;
		this.admission = admission;
		this.status = status;
		this.gender = gender;
		this.address = address;
		this.emailId = emailId;
	}

	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getApplicantDegree() {
		return applicantDegree;
	}
	public void setApplicantDegree(String applicantDegree) {
		this.applicantDegree = applicantDegree;
	}
	public int getApplicantGraduationPercent() {
		return applicantGraduationPercent;
	}
	public void setApplicantGraduationPercent(int applicantGraduationPercent) {
		this.applicantGraduationPercent = applicantGraduationPercent;
	}
	public Admission getAdmission() {
		return admission;
	}
	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	public AdmissionStatus getStatus() {
		return status;
	}
	public void setStatus(AdmissionStatus status) {
		this.status = status;
	}
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}	