package com.cg.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.StaffCredentials;
import com.cg.mts.service.StaffCredentialsService;

@RestController
@RequestMapping("/stafflogin")
public class StaffCredentialsController {
	
	@Autowired
	StaffCredentialsService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerStaff( @RequestBody StaffCredentials staff) {
		
		service.registerStaff(staff);
		
		return new ResponseEntity<>("University Staff Member is registered successfully!", HttpStatus.OK);
		
	}
	

}
