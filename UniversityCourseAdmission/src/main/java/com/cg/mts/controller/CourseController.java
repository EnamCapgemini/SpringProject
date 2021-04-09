package com.cg.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Course;
import com.cg.mts.service.CourseService;

@RestController
@RequestMapping("/Courses")
public class CourseController {

	@Autowired
	CourseService service;

	@DeleteMapping("{cid}")
	public ResponseEntity<?> deleteCourseById(@RequestBody Course c) {

		service.deleteCourseById(c);

		return new ResponseEntity<>("Course deleted Successfully!", HttpStatus.OK);

	}
}
