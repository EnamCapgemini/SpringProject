package com.cg.mts.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "UniversityStaffs")
public class UniversityStaffMember implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "STAFF_ID")
	private int staffId;

	@NotEmpty(message = "Password must have to given")
	@NotNull(message = "Password can't be Null")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8, 20}$", message = "Password must contains one uppercase letter, one lowercase letter, one digit and a special character. Don't use any WhiteSapce.")
	@Length(min = 8, max = 20,message = "Password length should be 8-20 characters")
	@Column(name="STAFF_PASSWORD")
	private String password;

	@NotEmpty(message = "Staff Role must have to given")
	@NotNull(message = "Staff Role can't be Null")
	@Length(min = 2, max = 20)
	@Column(name="STAFF_ROLE")
	private String role;
	
	@OneToMany(mappedBy="courses",cascade=CascadeType.ALL)
	private Set<Course> courses = new HashSet<>();

	public UniversityStaffMember() {

	}

	public UniversityStaffMember(int staffId, String password, String role) {
		super();
		this.staffId = staffId;
		this.password = password;
		this.role = role;
	}


	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public void addCourses(Course c) {
		c.setUniversitystaff(this);
		this.getCourses().add(c);
	}
	

}
