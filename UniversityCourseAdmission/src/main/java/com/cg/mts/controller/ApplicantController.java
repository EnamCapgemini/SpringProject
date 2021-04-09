package com.cg.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Applicant;
import com.cg.mts.service.ApplicantService;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {
	@Autowired
	ApplicantService service;
	
	@PutMapping("/update")
	public ResponseEntity<?> updateApplicant(@RequestBody Applicant applicant){
		service.updateApplicant(applicant);
		return new ResponseEntity<>("Applicant data saved successfully!!...",HttpStatus.OK);
	}
}
