package com.cg.mts.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admission")
public class Admission {
	
	@Id
	@Column(name = "ADMISSION_Id")
	private int admissionId;
	
	@Column(name = "COURSE_ID")
	private int courseId;
	
	@Column(name = "APPLICANT_ID")
	private int applicantId;
	
	@Column(name = "ADMISSION_DATE")
	private LocalDate admissionDate;
	
	@Column(name = "STATUS")
	private AdmissionStatus status;

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

	public AdmissionStatus getStatus() {
		return status;
	}

	public void setStatus(AdmissionStatus status) {
		this.status = status;
	}

}
