package com.cg.mts.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.DAOUser;
import com.cg.mts.entities.UniversityStaffMember;
<<<<<<< Updated upstream
import com.cg.mts.entities.User;
import com.cg.mts.exceptions.DataNotFoundException;
=======
>>>>>>> Stashed changes
import com.cg.mts.exceptions.DuplicateDataException;
import com.cg.mts.exceptions.EmptyDataException;
//import com.cg.mts.exceptions.DuplicateCourseException;
import com.cg.mts.exceptions.DuplicateDataException;
//import com.cg.mts.exceptions.EmptyDataException;

import com.cg.mts.repository.ICourseRepository;
import com.cg.mts.repository.IUniversityStaffRepository;
import com.cg.mts.repository.UserDao;

@Service
public class UniversityStaffService implements IUniversityStaffService {

	@Autowired
	IUniversityStaffRepository universityRepo;

	@Autowired
	ICourseRepository courseRepo;

	@Autowired
<<<<<<< Updated upstream
	UserRepository userRepository;
=======
	UserDao userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

>>>>>>> Stashed changes

	// Method to get All Staffs
	public List<UniversityStaffMember> viewAllStaffs() {
		List<UniversityStaffMember> list = (List<UniversityStaffMember>) universityRepo.findAll();
		return list;
	}

<<<<<<< Updated upstream
	// Method to get one Staff Details
=======
>>>>>>> Stashed changes
	public UniversityStaffMember viewStaff(int id) {
		Optional<UniversityStaffMember> opt = universityRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

<<<<<<< Updated upstream
	// Method to add Staff Details
	public void addStaff(UniversityStaffMember staff) throws DuplicateDataException {
		if (universityRepo.existsById(staff.getStaffId()))
			throw new DuplicateDataException("Staff with id " + staff.getStaffId() + " already exists");

		userRepository.save(new User("moot", staff.getPassword(), staff.getRole(), true));
=======
	public void addStaff(UniversityStaffMember staff) throws DuplicateDataException{
		if(universityRepo.existsById(staff.getStaffId()))
			throw new DuplicateDataException("Staff with id "+staff.getStaffId()+" already exists");

		// User is created here in User table
		DAOUser newUser = new DAOUser();
		newUser.setUsername(staff.getUsername());
		newUser.setPassword(bcryptEncoder.encode(staff.getPassword()));
		newUser.setRole(staff.getRole());
		newUser.setLoggedIn(false);
		userRepository.save(newUser);
>>>>>>> Stashed changes

		universityRepo.save(staff);
	}

<<<<<<< Updated upstream
	// Method to update Staff Details
=======

>>>>>>> Stashed changes
	public boolean updateStaff(UniversityStaffMember staff) {
		if (universityRepo.existsById(staff.getStaffId())) {
			universityRepo.save(staff);
			return true;
		}
		return false;
	}

<<<<<<< Updated upstream
	// Method to remove Staff Details
	public boolean removeStaff(int id) {
		if (universityRepo.existsById(id)) {
=======
	public boolean removeStaff(int id) {
		if(universityRepo.existsById(id)) {		
>>>>>>> Stashed changes
			universityRepo.deleteById(id);
			return true;
		}
		return false;
	}

<<<<<<< Updated upstream
	// Method to Add courses By Staff
	public void addCourse(Course c, int staffId) throws DuplicateDataException {
=======
	public void addCourse(Course c) throws DuplicateDataException {
>>>>>>> Stashed changes
		if (courseRepo.existsById(c.getCourseId()))
			throw new DuplicateDataException("Course with id " + c.getCourseId() + " Already exists");
		if (!universityRepo.existsById(staffId))
			throw new DataNotFoundException("Checking", "Staff with id " + staffId + " not present in database");
		courseRepo.saveByStaffId(c.getCourseId(), c.getCourseDuration(), c.getCourseEndDate(), c.getCourseFees(),
				c.getCourseName(), c.getCourseStartDate(), staffId);
	}

	// Method to remove Course by Staff
	public boolean removeCourse(int id) {
<<<<<<< Updated upstream
		if (courseRepo.existsById(id)) {
			courseRepo.deleteById(id);
=======
		if(courseRepo.existsById(id)) {
			courseRepo.deleteById(id); 
>>>>>>> Stashed changes
			return true;
		}
		return false;
	}

<<<<<<< Updated upstream
	// Method to update Course by Staff
	public boolean updateCourse(Course c, int courseId) {
		if (courseRepo.existsById(courseId)) {
			courseRepo.updateCourseDetails(c.getCourseName(), c.getCourseDuration(), c.getCourseStartDate(),
					c.getCourseEndDate(), c.getCourseFees(), courseId);
=======
	public boolean updateCourse(Course c) {
		if (courseRepo.existsById(c.getCourseId())) {
			courseRepo.save(c);
>>>>>>> Stashed changes
			return true;
		}
		return false;
	}

	// Method to get All Course Details under the Given Staff ID
	public Set<Course> viewAllCoursesUnderThisStaffId(int id) {
		Set<Course> set = (Set<Course>) universityRepo.getAllCoursesByStaffId(id);
		return set;
	}

}
