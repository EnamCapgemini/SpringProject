package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.entities.User;
import com.cg.mts.exceptions.DuplicateDataException;
import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.repository.UserRepository;
//import com.cg.mts.exceptions.DuplicateCourseException;
import com.cg.mts.exceptions.DuplicateDataException;
//import com.cg.mts.exceptions.EmptyDataException;

import com.cg.mts.repository.ICourseRepository;
import com.cg.mts.repository.IUniversityStaffRepository;


@Service
public class UniversityStaffService {

	@Autowired
	IUniversityStaffRepository universityRepo;
	
	@Autowired
	ICourseRepository courseRepo;
	
	@Autowired
	UserRepository userRepository;
	

	public List<UniversityStaffMember> viewAllStaffs() {
		List<UniversityStaffMember> list=(List<UniversityStaffMember>) universityRepo.findAll();
		return list;
	}
	
	public UniversityStaffMember viewStaff(int id) {
		Optional<UniversityStaffMember> opt=universityRepo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}
	
	public void addStaff(UniversityStaffMember staff) throws DuplicateDataException{
		if(universityRepo.existsById(staff.getStaffId()))
			throw new DuplicateDataException("Staff with id "+staff.getStaffId()+" already exists");
		
			userRepository.save(new User("moot", staff.getPassword(), staff.getRole(), true));
			
			universityRepo.save(staff);
		}
	
	
	public boolean updateStaff(UniversityStaffMember staff) {
		if(universityRepo.existsById(staff.getStaffId())) {
			universityRepo.save(staff);
			return true;
		}
		return false;
	}
	
	public boolean removeStaff(int id) {
		if(universityRepo.existsById(id)) {
			universityRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public void addCourse(Course c) throws DuplicateDataException {
		if (courseRepo.existsById(c.getCourseId()))
			throw new DuplicateDataException("Course with" + c.getCourseId() + "Already exists");
		courseRepo.save(c);
	}

	public boolean removeCourse(int id) {
		if(courseRepo.existsById(id)) {
			courseRepo.deleteById(id); 
		return true;
		}
	return false;
	}
	
	public boolean updateCourse(Course c) {
		if (courseRepo.existsById(c.getCourseId())) {
			courseRepo.save(c);
			return true;
		}
		return false;
	}

}
