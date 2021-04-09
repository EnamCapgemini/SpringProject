package com.cg.mts.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.service.AdmissionCommiteeMemberService;


@RestController
@RequestMapping("/AdmissionCommiteeMember")
public class AdmissionCommiteeMemberController {
	
	@Autowired
	AdmissionCommiteeMemberService service;
	
	@PostMapping("/addCommiteeMember")
	public ResponseEntity<?> saveAdmissionCommiteeMember(@Valid @RequestBody AdmissionCommiteeMember acm) {
		
		service.save(acm);
		
		return new ResponseEntity<>("Commitee Member saved successfully!", HttpStatus.OK);
		
	}
	

}
