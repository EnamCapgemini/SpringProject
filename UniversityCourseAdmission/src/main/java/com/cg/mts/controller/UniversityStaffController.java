package com.cg.mts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	public List<UniversityStaffMember> getAllStaffs(){
		List<UniversityStaffMember> list=universityService.getAllUniversitySatffs();
		if(list.size()==0)
			throw new EmptyDataException("No University Satff in Database.");
		return list;
	}
	
	@GetMapping("/{staffId}")
	public ResponseEntity<?> getStaffMember(@PathVariable("staffId") int sid){
		UniversityStaffMember staff=universityService.getStaff(sid);
		if(staff==null)
			throw new DataNotFoundException("Request", "Staff with id "+sid+" not found");
		else
			return new ResponseEntity<UniversityStaffMember>(staff,HttpStatus.OK);
	}
	
	@PostMapping
	public String saveStaffMember(@Valid @RequestBody UniversityStaffMember staff) {
		if(universityService.getStaff(staff.getStaffId())==null)
		{
			universityService.saveStaff(staff);
			return "Data saved Succesfully";
		}
		return "Duplicate Staff ID";
	}
	
	@PutMapping
	public String updateStaffMember(@Valid @RequestBody UniversityStaffMember staff) {
		if(universityService.updateStaff(staff))
			return "Staff data updated";
		else
			throw new DataNotFoundException("Update", "Staff with id "+staff.getStaffId()+" not found");
	}
	
	@PatchMapping("/{staffId}/{staffRole}")
	public String updateStaffRole(@PathVariable("staffId")int id,@PathVariable("staffRole")String role) {
		UniversityStaffMember staff=universityService.getStaff(id);
		if(staff==null)
			return "Staff data with id: "+id+" Not Exists";
		staff.setRole(role);
		universityService.updateStaff(staff);
		return "Staff Role Updated Succesfully";
	}
	
	@DeleteMapping("/{staffId}")
	public String deleteStaffMember(@PathVariable("staffId") int sId) {
		if(universityService.deleteStaff(sId))
			return "Staff Data Deleted Succesfully";
		else
			throw new DataNotFoundException("Delete", "Staff with id "+sId+" not found");
	}
	

}
