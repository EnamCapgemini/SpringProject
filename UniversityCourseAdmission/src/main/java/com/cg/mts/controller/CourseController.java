package com.cg.mts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Course;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.service.CourseService;

@RestController
@RequestMapping("/Courses")
public class CourseController {

	private static final String String = null;
	@Autowired
	CourseService service;

	@DeleteMapping("{cid}")
	public String removeCourse(@PathVariable("cid") int id) {
		if (service.removeCourse(id))
			return "data deleted";
		else
			throw new DataNotFoundException("Delete", "Course with id to delete " + id + "not found");
	}

	@PostMapping
	public String addCourse(@Valid @RequestBody Course c) {
		service.addCourse(c);
		return "Course successsfully added";
	}

	@PutMapping
	public String updateCourse(@Valid @RequestBody Course c) {
		if (service.updateCourse(c))
			return "data updated";
		else
			throw new DataNotFoundException("Update", "Course with id" + c.getCourseId() + "not found");
	}

	@GetMapping("{cid}")
	public ResponseEntity<?> viewcourse(@PathVariable("cid") int courseId) {
		Course c = service.viewCourse(courseId);
		if (c == null)
			throw new DataNotFoundException("Request", "Course with id " + courseId + "not found");
		return new ResponseEntity<Course>(c, HttpStatus.OK);
	}

	@GetMapping("/ShowOnlyBTechCourses")
	public List<Course> findCourseStartsWith() {
		List<Course> list = service.findCourseStartsWith();
		if (list.size() == 0)
			throw new EmptyDataException("No Courses in database");
		return list;
	}

	@GetMapping("/ShowOnlyBScCourses")
	public List<Course> ShowBScCourse() {
		List<Course> list = service.ShowBScCourse();
		if (list.size() == 0)
			throw new EmptyDataException("No Courses in database");
		return list;
	}
	@GetMapping("/ShowOnlyMTECHCourses")
	public List<Course> showMTechCourse() {
		List<Course> list = service.showMTechCourse();
		if (list.size() == 0)
			throw new EmptyDataException("No Courses in database");
		return list;
	}

	@GetMapping("/Show4YearCourses")
	public List<Course> year4CourseDuration() {
		List<Course> list = service.year4CourseDuration();
		if (list.size() == 0)
			throw new EmptyDataException("No Courses in database");
		return list;
	}

	@GetMapping("/Show3YearCourses")
	public List<Course> year3CourseDuration() {
		List<Course> list = service.year3CourseDuration();
		if (list.size() == 0)
			throw new EmptyDataException("No Courses in database");
		return list;
	}
	
	@GetMapping
	public List<Course> viewAllCourse() {
		List<Course> list = service.viewAllCourses();
		if (list.size() == 0)
			throw new EmptyDataException("No Courses in database");
		return list;
	}

}