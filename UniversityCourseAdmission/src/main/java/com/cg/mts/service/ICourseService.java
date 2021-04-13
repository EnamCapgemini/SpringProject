package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Course;


public interface ICourseService {
	
	void addCourse(Course c) ;
	boolean updateCourse(Course c);
	boolean removeCourse(int id);
	Course viewCourse(int id);
	List<Course> viewAllCourses();
    List<Course> findCourseStartsWith();
    List<Course> ShowBScCourse();

	/*List<Course> findBystartsEndsWith();*/
}
