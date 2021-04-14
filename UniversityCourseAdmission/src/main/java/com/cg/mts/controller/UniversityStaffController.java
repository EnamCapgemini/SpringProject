package com.cg.mts.controller;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import javax.websocket.Session;

import org.h2.command.ddl.CreateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.service.CourseService;
import com.cg.mts.service.UniversityStaffService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@RestController
@RequestMapping("/UniversityStaffs")
@JsonIgnoreProperties("Password")
public class UniversityStaffController {

	@Autowired
	UniversityStaffService universityService;
	
	@Autowired
	CourseService courseService;
	
	@PersistenceContext
    EntityManager entityManager;

	
	@GetMapping
	public List<UniversityStaffMember> viewAllStaffs(){
		List<UniversityStaffMember> list=universityService.viewAllStaffs();
		if(list.size()==0)
			throw new EmptyDataException("No University Satff in Database.");
		return list;
	}
	
	@GetMapping("/{staffId}")
	public ResponseEntity<?> viewStaff(@PathVariable("staffId") int sid) {
		UniversityStaffMember staff=universityService.viewStaff(sid);
		if(staff==null)
			throw new DataNotFoundException("Request", "Staff with id "+sid+" not found");
		else
			return new ResponseEntity<UniversityStaffMember>(staff,HttpStatus.OK);
	}
	
	@PostMapping
	public String addStaff(@Valid @RequestBody UniversityStaffMember staff) {
		if(universityService.viewStaff(staff.getStaffId())==null)
		{
			universityService.addStaff(staff);
			return "Data saved Succesfully";
		}
		return "Duplicate Staff ID";
	}
	
	@PutMapping
	public String updateStaff(@Valid @RequestBody UniversityStaffMember staff) {
		if(universityService.updateStaff(staff))
			return "Staff data updated";
		else
			throw new DataNotFoundException("Update", "Staff with id "+staff.getStaffId()+" not found");
	}
	
	
	@DeleteMapping("/{staffId}")
	public String removeStaff(@PathVariable("staffId") int sId) {
		if(universityService.removeStaff(sId))
			return "Staff Data Deleted Succesfully";
		else
			throw new DataNotFoundException("Delete", "Staff with id "+sId+" not found");
	}
	
	@GetMapping("/findCourseDetailsWithCourseID/{courseId}")
	public ResponseEntity<?> getCourse(@PathVariable("courseId") int id) {
		//UniversityStaffMember staff=universityService.viewStaff(sid);
		Course c=courseService.viewCourse(id);
		if(c==null)
			throw new DataNotFoundException("Request", "course with id "+id+" not found.");
		else
			return new ResponseEntity<Course>(c,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/addCourseByStaff")
	public String addCourse(@Valid @RequestBody Course c) {
		if(courseService.viewCourse(c.getCourseId())==null)
		{
			courseService.addCourse(c);
			return "Course Details saved Succesfully";
		}
		return "Duplicate Course ID";
	}
	
	@PutMapping("/updateCourseDetails")
	public String updateCourse(@Valid @RequestBody Course c) {
		if(courseService.updateCourse(c))
			return "Course Details Updated";
		else
			throw new DataNotFoundException("Update", "Course with id "+c.getCourseId()+" not found");
	}
	
	
	@DeleteMapping("/deleteCourseUsingCourseID/{courseId}")
	public String removeCourseByStaff(@PathVariable("courseId") int id) {
		if(courseService.removeCourse(id))
			return "course Data Deleted Succesfully";
		else
			throw new DataNotFoundException("Delete", "Course with id "+id+" not found");
	}
	
	
	@GetMapping("/findCoursesUnderStaffID/{staffID}")
	public Set<Course> viewAllCourses(@PathVariable("staffID")int id){
		Set<Course> set=universityService.viewAllCoursesUnderThisStaffId(id);
		if(set.size()==0)
			throw new EmptyDataException("No Courses under this Staff ID.");
		return set;
	}

}
