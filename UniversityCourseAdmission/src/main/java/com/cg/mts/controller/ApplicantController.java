package com.cg.mts.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Applicant;
import com.cg.mts.exceptions.ApplicantNotFoundException;
import com.cg.mts.service.ApplicantService;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {
	@Autowired
	ApplicantService service;
	
	@GetMapping("/{appid}")
	public ResponseEntity<?> getApplicant(@PathVariable("appid") int applicantId){
		Applicant applicant=service.viewApplicant(applicantId);
		if(applicant==null)
			throw new ApplicantNotFoundException("applicant with id "+applicantId+" not found");
		
		return new ResponseEntity<Applicant>(applicant,HttpStatus.OK);
	}
	@PostMapping
	public String saveApplicant(@Valid @RequestBody Applicant applicant) {
		service.addApplicant(applicant);
		
		return "data saved";	
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateApplicant(@RequestBody Applicant applicant){
		service.updateApplicant(applicant);
		return new ResponseEntity<>("Applicant data saved successfully!!...",HttpStatus.OK);
	}
	
	@DeleteMapping("/{appid}")
	public String deleteApplicants(@PathVariable("appid") int applicantId) {
		if(service.deleteApplicant(applicantId))
			return "data deleted";
		else
			throw new  ApplicantNotFoundException("applicant with id "+applicantId+" not found");
	}
	
}
