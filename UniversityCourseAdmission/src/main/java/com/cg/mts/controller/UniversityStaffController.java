package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.service.UniversityStaffService;

@RestController
@RequestMapping("/UniversityStaffs")
public class UniversityStaffController {

	@Autowired
	UniversityStaffService universityService;
	
	@GetMapping
	public List<UniversityStaffMember> getAllStaffs(){
		List<UniversityStaffMember> list=universityService.getAllUniversitySatffs();
		if(list.size()==0)
			throw new EmptyDataException("No University Satff in Database.");
		return list;
	}
	
}
