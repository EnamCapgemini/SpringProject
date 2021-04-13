package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Course;


public interface ICourseService {
	
	void addCourse(Course c) ;
	boolean updateCourse(Course c);
	boolean removeCourse(int id);
	Course viewCourse(int id);
	List<Course> viewAllCourses();
<<<<<<< HEAD
	
=======
	/*List<Course> findBystartsEndsWith();*/
>>>>>>> 99e6feaacbd7c53cd68eb3873e6c765f748a3696
}
