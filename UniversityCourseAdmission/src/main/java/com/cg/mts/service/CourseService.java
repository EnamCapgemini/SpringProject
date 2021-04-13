package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.Course;
import com.cg.mts.exceptions.DuplicateDataException;
import com.cg.mts.repository.ICourseRepository;

@Service
public class CourseService implements ICourseService{
	@Autowired
	ICourseRepository repository;
	
	Course c;

	public boolean removeCourse(int id) {
		if(repository.existsById(id)) {
			repository.deleteById(id); 
		return true;}
	return false;
	}
	
	public void addCourse(Course c) throws DuplicateDataException {
		if (repository.existsById(c.getCourseId()))
			throw new DuplicateDataException("Course with" + c.getCourseId() + "Already exists");
		repository.save(c);
	}

	public boolean updateCourse(Course c) {
		if (repository.existsById(c.getCourseId())) {
			repository.save(c);
			return true;
		}
		return false;
	}

	public Course viewCourse(int id) {
		Optional<Course> opt = repository.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;

	}
	
	public List<Course> viewAllCourses() {
		List<Course> list=(List<Course>) repository.findAll();
		return list;
	}

	@Override
	public List<Course> findCourseStartsWith() {
		List<Course>  coursenames=(List<Course>)repository.findCourseStartsWith();
		return coursenames;
	}
	public List<Course> ShowBScCourse() {
		List<Course>  coursenames=(List<Course>)repository.ShowBScCourse();
		return coursenames;
	}
	 

}
