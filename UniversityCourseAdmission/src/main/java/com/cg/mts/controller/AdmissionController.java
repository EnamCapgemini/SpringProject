package com.cg.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Admission;
import com.cg.mts.exceptions.AdmissionIdNotFoundException;
import com.cg.mts.service.AdmissionService;


@RestController
@RequestMapping("/Admission")
public class AdmissionController {
	
	@Autowired
	AdmissionService service;
	
		@GetMapping("{aid}")
	    public ResponseEntity<?> getCourse(@PathVariable("aid") int admissionId) {
	        Admission c=service.get(admissionId);
	        if (c==null)
	            throw new AdmissionIdNotFoundException("Admission with id "+admissionId+"not found");
	        return new ResponseEntity<Admission>(c,HttpStatus.OK);
	        }

}
