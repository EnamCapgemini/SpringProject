package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.entities.User;
import com.cg.mts.exceptions.DuplicateDataException;
import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.repository.UniversityStaffRepository;
import com.cg.mts.repository.UserRepository;

@Service
public class UniversityStaffService {

	@Autowired
	UniversityStaffRepository universityRepo;
	
	@Autowired
	UserRepository userRepository;
	
	public List<UniversityStaffMember> getAllUniversitySatffs() {
		List<UniversityStaffMember> list=(List<UniversityStaffMember>) universityRepo.findAll();
		return list;
	}
	
	public UniversityStaffMember getStaff(int id) {
		Optional<UniversityStaffMember> opt=universityRepo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}
	
	public void saveStaff(UniversityStaffMember staff) throws DuplicateDataException{
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
	
	public boolean deleteStaff(int id) {
		if(universityRepo.existsById(id)) {
			universityRepo.deleteById(id);
			return true;
		}
		return false;
	}
}
