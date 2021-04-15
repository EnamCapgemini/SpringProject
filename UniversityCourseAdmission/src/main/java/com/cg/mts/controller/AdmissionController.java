package com.cg.mts.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.cg.mts.entities.Admission;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.service.AdmissionService;

@RestController
@RequestMapping("/Admission")
public class AdmissionController {

	@Autowired
	AdmissionService service;

	@GetMapping("{aid}")
	public ResponseEntity<?> getAdmission(@PathVariable("aid") int admissionId) {
		Admission c = service.getAdmission(admissionId);
		if (c == null)
			throw new DataNotFoundException("request","Admission with id " + admissionId + "not found");
		return new ResponseEntity<Admission>(c, HttpStatus.OK);
	}
	
	@PostMapping
	public String saveAdmission(@Valid @RequestBody Admission a) {
		service.addAdmission(a);
		
		return "Data Saved";
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateAdmission(@RequestBody Admission a){
		service.updateAdmission(a);
		return new ResponseEntity<>("Admission Data Saved Successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/{aid}")
	public String deleteAdmission(@PathVariable("aid") int admissionId) {
		if(service.deleteAdmission(admissionId))
			return "Data Deleted";
		else
			throw new DataNotFoundException("detete","Admission with Id" +admissionId+ "not found");	
	}
	
	@GetMapping("/Date/{date}")
	public List<Admission> getAllByDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") String admissionDate){
		
		List<Admission> c = service.showAllByDate(admissionDate);
		if (c == null)
			throw new DataNotFoundException("request","Admission with date " + admissionDate + "not found");
		return c;
	}
	
}
