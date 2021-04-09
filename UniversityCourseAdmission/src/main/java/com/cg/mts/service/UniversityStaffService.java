package com.cg.mts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.repository.UniversityStaffRepository;

@Service
public class UniversityStaffService {

	@Autowired
	UniversityStaffRepository universityRepo;
	
	public List<UniversityStaffMember> getAllUniversitySatffs() {
		List<UniversityStaffMember> list=(List<UniversityStaffMember>) universityRepo.findAll();
		return list;
	}
}
