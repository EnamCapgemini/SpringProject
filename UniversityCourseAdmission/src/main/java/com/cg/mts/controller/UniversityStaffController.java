package com.cg.mts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.service.UniversityStaffService;


@RestController
@RequestMapping("/UniversityStaffs")

public class UniversityStaffController {

	@Autowired
	UniversityStaffService universityService;
	
	@GetMapping
	
	public List<UniversityStaffMember> viewAllStaffs(){
		List<UniversityStaffMember> list=universityService.viewAllStaffs();
		if(list.size()==0)
			throw new EmptyDataException("No University Satff in Database.");
		return list;
	}
	
	@GetMapping("/{staffId}")
	public ResponseEntity<?> viewStaff(@PathVariable("staffId") int sid){
		UniversityStaffMember staff=universityService.viewStaff(sid);
		if(staff==null)
			throw new DataNotFoundException("Request", "Staff with id "+sid+" not found");
		else
			return new ResponseEntity<UniversityStaffMember>(staff,HttpStatus.OK);
	}
	
	@PostMapping
	public String addStaff(@Valid @RequestBody UniversityStaffMember staff) {
		if(universityService.viewStaff(staff.getStaffId())==null)
		{
			universityService.addStaff(staff);
			return "Data saved Succesfully";
		}
		return "Duplicate Staff ID";
	}
	
	@PutMapping
	public String updateStaff(@Valid @RequestBody UniversityStaffMember staff) {
		if(universityService.updateStaff(staff))
			return "Staff data updated";
		else
			throw new DataNotFoundException("Update", "Staff with id "+staff.getStaffId()+" not found");
	}
	
	
	@DeleteMapping("/{staffId}")
	public String removeStaff(@PathVariable("staffId") int sId) {
		if(universityService.removeStaff(sId))
			return "Staff Data Deleted Succesfully";
		else
			throw new DataNotFoundException("Delete", "Staff with id "+sId+" not found");
	}

}
