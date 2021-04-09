package com.cg.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.StaffCredentials;
import com.cg.mts.exceptions.DuplicateStaffCredentialsException;
import com.cg.mts.repository.StaffCredentialsRepository;

@Service
public class StaffCredentialsService {

	@Autowired
	StaffCredentialsRepository repository;
	
	public void registerStaff(StaffCredentials staff) {
		
		if(repository.existsById(staff.getId())) {
			throw new DuplicateStaffCredentialsException("University Staff Member with id "+ staff.getId() +" alread exists!");
		}
		
		repository.save(staff);
		
	}
	
	

}
