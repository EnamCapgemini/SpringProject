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
	@Column(name = "APPLICANT_NAME")
	private String applicantName;
	
	
	@NotEmpty(message="mobile number should not be empty")
	@NotNull(message="mobile number is required")
	@Length(min=10,max=10,message="${phone.length.error}")	
	@Column(name = "PH_NO")
	private String mobileNumber;
	
	
	@NotEmpty(message="degree should not be empty")
	@NotNull(message="degree is required")
	@Length(min=3,max=10,message="${degree.length.error}")
	@Column(name = "DEGREE")
	private String applicantDegree;
	
	
	@NotEmpty(message="percent should not be empty")
	@NotNull(message="percent is required")
	@Column(name = "GRAD_PER")
	private int applicantGraduationPercent;
	
	@Column(name = "ADMISSION")
	private Admission admission;
	
	@Column(name = "ADMISSION_STATUS")
	private AdmissionStatus status;
	
	@Column(name = "GENDER")
	@NotEmpty(message="gender should not be empty")
	private Gender gender;
	
	@Column(name = "ADDRESS")
	@NotEmpty(message="address should not be empty")
	private Address address;
	
	@Column(name = "EMAIL_ID")
	@NotEmpty(message="email should not be empty")
	@NotNull(message="email is required")
	@Email(message = "email should be valid")
	private String emailId;
	

	public Applicant() {
		
	}
	
	public Applicant(String applicantId,String applicantName, String mobileNumber, String applicantDegree,int applicantGraduationPercent,Admission admission, AdmissionStatus status,Gender gender, Address address, String emailId) {
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