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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.AdmissionCommiteeMember;

import com.cg.mts.exceptions.AdmissionCommiteeMemberNotFoundException;

import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.service.AdmissionCommiteeMemberService;

@RestController
@RequestMapping("/AdmissionCommiteeMember")
public class AdmissionCommiteeMemberController {

	@Autowired
	AdmissionCommiteeMemberService service;

	@PostMapping("/addCommiteeMember")
	public ResponseEntity<?> saveAdmissionCommiteeMember(@Valid @RequestBody AdmissionCommiteeMember acm) {

		service.saveAdmissionCommiteeMember(acm);

		return new ResponseEntity<>("Admission Commitee Member saved successfully!", HttpStatus.OK);

	}

	@GetMapping("{acmid}")
	public ResponseEntity<?> getAdmissionCommiteeMember(@PathVariable("acmid") int memId) {
		AdmissionCommiteeMember acm = service.getAdmissionCommiteeMember(memId);
		if (acm == null)
			throw new AdmissionCommiteeMemberNotFoundException(
					"Admission Commitee Member with id " + memId + "not found");
		return new ResponseEntity<AdmissionCommiteeMember>(acm, HttpStatus.OK);
	}

	@GetMapping
	public List<AdmissionCommiteeMember> getAllAdmissionCommiteeMembers() {
		List<AdmissionCommiteeMember> list = service.getAllAdmissionCommiteeMembers();
		if (list.size() == 0)
			throw new EmptyDataException("No Admission Commitee Member in database");
		return list;
	}

	@PutMapping("/updateCommiteeMember")
	public String updateAdmissionCommiteeMember(@Valid @RequestBody AdmissionCommiteeMember acm) {
		if (service.updateAdmissionCommiteeMember(acm))
			return "Admission Commitee member data updated";
		else
			throw new AdmissionCommiteeMemberNotFoundException(
					"Admission Commitee Member with id" + acm.getAdmissionCommiteeMemberId() + "not found");
	}

	@DeleteMapping("{acmid}")
	public String deleteAdmissionCommiteeMember(@PathVariable("acmid") int id) {
		if (service.deleteAdmissionCommiteeMember(id))
			return "Admission Commitee Member data deleted";
		else
			throw new AdmissionCommiteeMemberNotFoundException(
					"Admission Commitee Member with id to delete " + id + "not found");
	}

	@PatchMapping("{​​​​​acmid}​​​​​/{​​​​​acmname}​​​​​")
    public String updateAdmissionCommiteeMemberName(@RequestParam("acmid") int acmid, @RequestParam("acmname") String acmname) {
		AdmissionCommiteeMember acm = service.getAdmissionCommiteeMember(acmid);
		if(acm == null)
			return "Admission Commitee Member for name update not found";
		
		acm.setAdmissionCommiteeMemberName(acmname);
		service.updateAdmissionCommiteeMember(acm);
		return "Admission Commitee Member name update sucessfull";
	}

}