package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;

public interface IUniversityStaffService {

	List<UniversityStaffMember> viewAllStaffs();
	UniversityStaffMember viewStaff(int id);
	void addStaff(UniversityStaffMember staff);
	boolean updateStaff(UniversityStaffMember staff);
	boolean removeStaff(int id);
	void addCourse(Course c);
	boolean removeCourse(int id);
	boolean updateCourse(Course c);
}
