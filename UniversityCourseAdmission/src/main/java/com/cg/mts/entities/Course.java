package com.cg.mts.entities;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="course")
@Embeddable
public class Course implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="COURSE_ID")
	private int courseId;

	@NotEmpty(message="course should not be empty")
	@NotNull(message="course is required")
	@Length(min=4,max=15,message="${name.length.error}")
	@Column(name = "COURSE_NAME")
	private String courseName;

	@NotEmpty(message="duration should not be empty")
	@NotNull(message="duration is required")
	@Column(name = "COURSE_DURATION")
	private String courseDuration;
	
	@Column(name = "COURSE_START_DATE")
	private LocalDate courseStartDate;
	
	@Column(name = "COURSE_END_DATE")
	private LocalDate courseEndDate;

	@NotEmpty(message="Fees should not be empty")
	@NotNull(message="Fees is required")
	@Column(name = "COURSE_FEES")
	private String courseFees;
	
	
	@OneToOne
	@JoinColumn(name="COURSE_ID")
	private Admission admission;

	

	public Course(){}

	public Course(int courseId, String courseName, String courseDuration, LocalDate courseStartDate,
			LocalDate courseEndDate, String courseFees) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.courseFees = courseFees;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	public LocalDate getCourseStartDate() {
		return courseStartDate;
	}
	public void setCourseStartDate(LocalDate courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	public LocalDate getCourseEndDate() {
		return courseEndDate;
	}
	public void setCourseEndDate(LocalDate courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	public String getCourseFees() {
		return courseFees;
	}
	public void setCourseFees(String courseFees) {
		this.courseFees = courseFees;
	}

	
	

}
