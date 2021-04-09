package com.cg.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.exceptions.DuplicateAdmissionCommiteeMemberException;
import com.cg.mts.repository.AdmissionCommiteeMemberRepository;

@Service
public class AdmissionCommiteeMemberService {

	@Autowired
	AdmissionCommiteeMemberRepository repository;

	public void save(AdmissionCommiteeMember e) {

		if (repository.existsById(e.getAdmissionCommiteeMemberId())) {
			throw new DuplicateAdmissionCommiteeMemberException(
					"Employee with id : " + e.getAdmissionCommiteeMemberId() + " already exists.");
		}
		repository.save(e);
	}

}