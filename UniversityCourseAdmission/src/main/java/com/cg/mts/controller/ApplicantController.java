package com.cg.mts.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Applicant;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.service.ApplicantService;
import com.cg.mts.service.JwtUserDetailsService;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {
	@Autowired
	ApplicantService service;
	
	@Autowired
	JwtUserDetailsService jwtUserDetailsService;
	
	@GetMapping("/{appid}")
	public ResponseEntity<?> getApplicant(@PathVariable("appid") int applicantId){
		Applicant applicant=service.viewApplicant(applicantId);
		if(applicant==null)
			throw new DataNotFoundException("request","applicant with id "+applicantId+" not found");
		
		return new ResponseEntity<Applicant>(applicant,HttpStatus.OK);
	}
	
	@PostMapping
	public String saveApplicant(@Valid @RequestBody Applicant applicant) {
		service.addApplicant(applicant);
		return "data saved";	
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateApplicant(@RequestHeader("Authorization") String token,@Valid @RequestBody Applicant applicant){
		String role = jwtUserDetailsService.getRoleFromToken(token);
		if(role.equalsIgnoreCase("APPLICANT")) {
		service.updateApplicant(applicant);
		return new ResponseEntity<>("Applicant data saved successfully!!...",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Invalid role!!...",HttpStatus.BAD_REQUEST);

		}
	}
	
	@DeleteMapping("/{appid}")
	public String deleteApplicants(@RequestHeader("Authorization") String token,@PathVariable("appid") int applicantId) {
		String role = jwtUserDetailsService.getRoleFromToken(token);
		if(role.equalsIgnoreCase("APPLICANT")) {
		if(service.deleteApplicant(applicantId))
			return "data deleted";
		else
			throw new  DataNotFoundException("delete","applicant with id "+applicantId+" not found");
		}
		else {
			return "Invalid Role..";
		}
	}
	
	@GetMapping("/show12thpassApplicants")
	public List<Applicant> get12thpass(){
		List<Applicant> list=service.get12thpass();
		if(list.size()==0)
			throw new EmptyDataException("No applicants with degree 12thpass");
		return list;
	}
	
	@GetMapping("/showBTechApplicants")
	public List<Applicant> getBtechDegree(){
		List<Applicant> list=service.getBtechDegree();
		if(list.size()==0)
			throw new EmptyDataException("No applicants with degree b.tech");
		return list;
	}
	
	@GetMapping("/show1stDivisionApplicants")
	public List<Applicant> showAll1stDivision(){
		List<Applicant> list=service.showAll1stDivision();
		if(list.size()==0)
			throw new EmptyDataException("No applicants more than 60%");
		return list;
	}
	
	@GetMapping("/showMaleApplicants")
	public List<Applicant> showMaleApplicants(){
		List<Applicant> list=service.showMaleApplicants();
		if(list.size()==0)
			throw new EmptyDataException("No male applicants");
		return list;
	}
	
	@GetMapping("/showFemaleApplicants")
	public List<Applicant> showFemaleApplicants(){
		List<Applicant> list=service.showFemaleApplicants();
		if(list.size()==0)
			throw new EmptyDataException("No female applicants");
		return list;
	}
}
