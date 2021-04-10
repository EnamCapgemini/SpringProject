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
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Course;
import com.cg.mts.exceptions.CourseNotFoundException;
import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.service.CourseService;

@RestController
@RequestMapping("/Courses")
public class CourseController {

	@Autowired
	CourseService service;

	@DeleteMapping("{cid}")
	public String deleteCourse(@PathVariable("cid") int id) {
		if(service.deleteCourse(id))
			return "data deleted";
		else
			throw new CourseNotFoundException("Course with id to delete "+ id+"not found");
	}
	@PostMapping
	public String saveCourse(@Valid @RequestBody Course c) {
		service.saveCourse(c);
		return "Course successsfully added";
	}

	@PutMapping
	public String updateCourse(@Valid @RequestBody Course c) {
		if (service.updateCourse(c))
			return "data updated";
		else
			throw new CourseNotFoundException("Course with id" + c.getCourseId() + "not found");
	}

	@GetMapping("{cid}")
	public ResponseEntity<?> getcourse(@PathVariable("cid") int courseId) {
		Course c = service.getCourse(courseId);
		if (c == null)
			throw new CourseNotFoundException("Course with id " + courseId + "not found");
		return new ResponseEntity<Course>(c, HttpStatus.OK);
	}

	@GetMapping
	public List<Course> getAllCourse() {
		List<Course> list = service.getAllCourses();
		if (list.size() == 0)
			throw new EmptyDataException("No Courses in database");
		return list;
	}
}
