package com.cg.mts.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ADMISSION")
public class Admission implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ADMISSION_Id")
	private int admissionId;

	@Column(name = "COURSE_ID")
	private int courseId;

	@Column(name = "APPLICANT_ID")
	private int applicantId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")	
	@Column(name = "ADMISSION_DATE")
	private LocalDate admissionDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private AdmissionStatus status;

	@OneToOne(mappedBy="admission")
	private Applicant applicant;
	

	@ManyToOne
	@JoinColumn(name="ADMISSION_COMMITEE_STAFF_ID")
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
