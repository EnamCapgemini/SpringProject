package com.cg.mts.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admission")
public class Admission implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ADMISSION_Id")
	private int admissionId;

	@Column(name = "COURSE_ID")
	private int courseId;

	@Column(name = "APPLICANT_ID")
	private int applicantId;

	@Column(name = "ADMISSION_DATE")
	private LocalDate admissionDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private AdmissionStatus status;

	@OneToOne(mappedBy="admission")
	private Applicant applicant;
	

	@ManyToOne
	@JoinColumn(name="admissionCommiteeMemberId")
	private AdmissionCommiteeMember admissioncommitee;

	public Admission() {
		super();
	}

	public Admission(int admissionId, int courseId, int applicantId, LocalDate admissionDate, AdmissionStatus status) {
		super();
		this.admissionId = admissionId;
		this.courseId = courseId;
		this.applicantId = applicantId;
		this.admissionDate = admissionDate;
		this.status = status;
	}

	public int getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}


	@Enumerated(EnumType.STRING)
	public AdmissionStatus getStatus() {
		return status;
	}

	public void setStatus(AdmissionStatus status) {
		this.status = status;
	}
	

}
