package com.cg.mts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.mts.entities.Applicant;
import com.cg.mts.exceptions.ApplicantNotFoundException;
import com.cg.mts.repository.ApplicantRepository;
@Service
public class ApplicantService {
	@Autowired
	ApplicantRepository repository;
	
	public boolean addApplicant(Applicant applicant) {
		
		repository.save(applicant);
		return true;
	}
	
	public boolean updateApplicant(Applicant applicant) {
		if(!(repository.existsById(applicant.getApplicantId()))) {
			throw new ApplicantNotFoundException("Applicant with id "+applicant.getApplicantId()+" not found!..");
		}
		else{
			repository.save(applicant);
			return true;
		}

	}
	public boolean deleteApplicant(int id) {
		if(!(repository.existsById(id))) {
			throw new ApplicantNotFoundException("Applicant with id "+id+" not found!..");
		} 
		else {
		repository.deleteById(id);
		 return true;
		}
	}
	public Applicant viewApplicant(int applicant) {
		Optional<Applicant> opt=repository.findById(applicant);
		if(opt.isPresent())
			return opt.get();
		return null;
	}
}
