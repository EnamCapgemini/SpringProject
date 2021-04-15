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

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.AdmissionStatus;
//import com.cg.mts.exceptions.AdmissionCommiteeMemberNotFoundException;
import com.cg.mts.exceptions.DataNotFoundException;
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

	@GetMapping("/getUserByAdmissionCommiteeMemberId/{acmid}")
	public ResponseEntity<?> findUserByAdmissionCommiteeMemberId(@PathVariable("acmid") int id) {
		AdmissionCommiteeMember acm = service.getUserbyAdmissionCommiteeMemberId(id);
		if (acm == null)
			throw new DataNotFoundException("Request", "Admission Commitee Member with id " + id + " not found");
		return new ResponseEntity<>(acm, HttpStatus.OK);
	}

	@GetMapping("/getUserByStaffId/{acmid}")
	public ResponseEntity<?> getAdmissionCommiteeMember(@PathVariable("acmid") int memId) {
		AdmissionCommiteeMember acm = service.getAdmissionCommiteeMember(memId);
		if (acm == null)
			throw new DataNotFoundException("Request", "Admission Commitee Member with id " + memId + " not found");
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
			throw new DataNotFoundException("Update",
					"Admission Commitee Member with id" + acm.getAdmissionCommiteeMemberId() + " not found");
	}

	@DeleteMapping("{acmid}")
	public String deleteAdmissionCommiteeMember(@PathVariable("acmid") int id) {
		if (service.deleteAdmissionCommiteeMember(id))
			return "Admission Commitee Member data deleted";
		else
			throw new DataNotFoundException("Delete",
					"Admission Commitee Member with id to delete " + id + " not found");
	}

	@PatchMapping("{​​​​​acmid}​​​​​/{​​​​​acmname}​​​​​")
	public String updateAdmissionCommiteeMemberName(@RequestParam("acmid") int acmid,
			@RequestParam("acmname") String acmname) {
		AdmissionCommiteeMember acm = service.getUserbyAdmissionCommiteeMemberId(acmid);
		if (acm == null)
			throw new DataNotFoundException("Update",
					"Admission Commitee Member with name to update with id " + acmid + " not found");

		acm.setAdmissionCommiteeMemberName(acmname);
		service.updateAdmissionCommiteeMember(acm);
		return "Admission Commitee Member name update sucessfull";
	}

	@PatchMapping("{​​​​​acmid}​​​​​/{​​​​​acmcont}​​​​​")
	public String updateAdmissionCommiteeMemberContact(@RequestParam("acmid") int acmid,
			@RequestParam("acmcont") String acmcont) {
		AdmissionCommiteeMember acm = service.getUserbyAdmissionCommiteeMemberId(acmid);
		if (acm == null)
			throw new DataNotFoundException("Update",
					"Admission Commitee Member with contact to update with id " + acmid + " not found");

		acm.setAdmissionCommiteeMemberContact(acmcont);
		service.updateAdmissionCommiteeMember(acm);
		return "Admission Commitee Member contact update sucessfull";
	}

//	@PatchMapping("/change/{applicantId}/{grad}")
//	public String updateStatus(@PathVariable("applicantId") int id,@PathVariable("grad") int grad) {
//		String str=service.getStatusByIdGrad(id, grad);
//		if(grad>60)
//			str=AdmissionStatus.CONFIRMED.toString();
//		else
//			str=AdmissionStatus.REJECTED.toString();
//		return str;
//	}

	@PatchMapping("{​​​​​adid}​​​​​/{​​​​​adstatus}​​​​​")
	public String updateAdmissionStatus(@RequestParam("adid") int adid,
			@RequestParam("adstatus") AdmissionStatus adstatus) {
		if (service.provideAdmissionResult(adid, adstatus))
			return "Admission Result data of "+ adid +" updated";
		else
			throw new DataNotFoundException("Update",
					"Admission Commitee Member with id" + adid + " not found");

	}

}