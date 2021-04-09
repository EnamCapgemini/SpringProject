package com.cg.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.exceptions.CourseNotFoundException;
import com.cg.mts.service.CourseService;


@RestController
@RequestMapping("/Courses")
public class CourseController {
	
	@Autowired
	CourseService service;
	
	@DeleteMapping("{cid}")
	public String deleteCourse(@PathVariable("cid") int id) {
		if(service.deleteCourseById(id))
			return "data deleted";
		else
			throw new CourseNotFoundException("Delete Failed","Course with id to delete "+ id+"not found");
	}
	

}