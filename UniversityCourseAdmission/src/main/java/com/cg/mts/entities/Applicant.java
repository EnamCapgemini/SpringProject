package com.cg.mts.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "APPLICANT")
public class Applicant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "APPLICANT_ID")
	private String applicantId;

	@Column(name = "APPLICANT_FIRSTNAME")
	private String applicantFirstName;

	@Column(name = "APPLICANT_LASTNAME")
	private String applicantLastName;

	@NotEmpty(message = "mobile number should not be empty")
	@NotNull(message = "mobile number is required")
	@Length(min = 10, max = 10, message = "${phone.length.error}")
	@Column(name = "PH_NO")
	private String mobileNumber;

	@NotEmpty(message = "degree should not be empty")
	@NotNull(message = "degree is required")
	@Length(min = 3, max = 10, message = "${degree.length.error}")
	@Column(name = "DEGREE")
	private String applicantDegree;

	@NotEmpty(message = "percent should not be empty")
	@NotNull(message = "percent is required")
	@Column(name = "GRAD_PER")
	private int applicantGraduationPercent;

	@OneToOne
	@JoinColumn(name = "ADMISSION_ID")
	private Admission admission;

	@OneToOne
	@JoinColumn(name = "COURSE")
	private Course course; ////////////////

	@Column(name = "GENDER")
	@NotEmpty(message = "gender should not be empty")
	private Gender gender;

	@OneToOne
	@JoinColumn(name = "ADDRESS")
	@NotEmpty(message = "address should not be empty")
	private Address address;

	@Column(name = "EMAIL_ID")
	@NotEmpty(message = "email should not be empty")
	@NotNull(message = "email is required")
	@Email(message = "email should be valid")
	private String emailId;

	public Applicant() {

	}

	public Applicant(String applicantId, String applicantFirstName, String applicantLastName, String mobileNumber,
			String applicantDegree, int applicantGraduationPercent, Gender gender, Address address, String emailId) {
		super();
		this.applicantId = applicantId;
		this.applicantFirstName = applicantFirstName;
		this.applicantLastName = applicantLastName;
		this.mobileNumber = mobileNumber;
		this.applicantDegree = applicantDegree;
		this.applicantGraduationPercent = applicantGraduationPercent;
		this.admission = admission;
		this.course = course;
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

	public String getApplicantFirstName() {
		return applicantFirstName;
	}

	public void setApplicantFirstName(String applicantFirstName) {
		this.applicantFirstName = applicantFirstName;
	}

	public String getApplicantLastName() {
		return applicantLastName;
	}

	public void setApplicantLastName(String applicantLastName) {
		this.applicantLastName = applicantLastName;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}