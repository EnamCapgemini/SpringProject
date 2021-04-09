package com.cg.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.Course;
import com.cg.mts.exceptions.ApplicantNotFoundException;
import com.cg.mts.exceptions.CourseNotFoundException;
import com.cg.mts.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository repository;
	Course c;
	public boolean deleteCourse(Course c) {
		if(!(repository.existsById(c.getCourseId()))) {
			repository.deleteById(c.getCourseId());
		}
		
		else{
			throw new CourseNotFoundException("Applicant with id "+c.getCourseId()+" not found!..");
		}
		return false;

	}
}
