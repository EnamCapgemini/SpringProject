package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.Applicant;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.repository.ApplicantRepository;
@Service
public class ApplicantService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	ApplicantRepository repository;
	
	public boolean addApplicant(Applicant applicant) {
		
		repository.save(applicant);
		return true;
	}
	
	public boolean updateApplicant(Applicant applicant) {
		if(!(repository.existsById(applicant.getApplicantId()))) {
			throw new DataNotFoundException("update","Applicant with id "+applicant.getApplicantId()+" not found!..");
		}
		else{
			repository.save(applicant);
			return true;
		}

	}
	public boolean deleteApplicant(int id) {
		if(!(repository.existsById(id))) {
			throw new DataNotFoundException("delete","Applicant with id "+id+" not found!..");
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
	public List<Admission> findAll(){
	
		return em.createQuery("select r.status from Admission r join Applicant c on r.applicantId = c.applicantId",Admission.class).getResultList();
		 
	}
}
