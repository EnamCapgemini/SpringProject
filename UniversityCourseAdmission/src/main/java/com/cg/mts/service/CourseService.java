package com.cg.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Course;
import com.cg.mts.exceptions.CourseNotFoundException;
import com.cg.mts.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository repository;

	public boolean deleteCourseById(Course c) {
		if (repository.existsById(c.getCourseId())) {
			repository.deleteById(c.getCourseId());
			return true;
		} else
			throw new CourseNotFoundException("course with id " + c.getCourseId() + "doesnt exist");
	}

}
