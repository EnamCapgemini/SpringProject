package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.Course;
import com.cg.mts.exceptions.ApplicantNotFoundException;
import com.cg.mts.exceptions.CourseNotFoundException;
import com.cg.mts.exceptions.DuplicateCourseException;
import com.cg.mts.exceptions.DuplicateDataException;
import com.cg.mts.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository repository;
	Course c;

	public boolean deleteCourse(int id) {
		if(repository.existsById(id)) {
			repository.deleteById(id); 
		return true;}
	return false;
	}
	
	public void saveCourse(Course c) throws DuplicateDataException {
		if (repository.existsById(c.getCourseId()))
			throw new DuplicateCourseException("Course with" + c.getCourseId() + "Already exists");
		repository.save(c);
	}

	public boolean updateCourse(Course c) {
		if (repository.existsById(c.getCourseId())) {
			repository.save(c);
			return true;
		}
		return false;
	}

	public Course getCourse(int id) {
		Optional<Course> opt = repository.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;

	}
	
	public List<Course> getAllCourses() {
		List<Course> list=(List<Course>) repository.findAll();
		return list;
	}
}
