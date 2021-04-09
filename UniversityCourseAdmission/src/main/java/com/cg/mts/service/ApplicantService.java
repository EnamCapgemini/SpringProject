package com.cg.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Applicant;
import com.cg.mts.exceptions.ApplicantNotFoundException;
import com.cg.mts.repository.ApplicantRepository;
@Service
public class ApplicantService {
	@Autowired
	ApplicantRepository repository;
	
	public boolean updateApplicant(Applicant applicant) {
		if(!(repository.existsById(applicant.getApplicantId()))) {
			throw new ApplicantNotFoundException("Applicant with id "+applicant.getApplicantId()+" not found!..");
		}
		else{
			repository.save(applicant);
			return true;
		}

	}
}
