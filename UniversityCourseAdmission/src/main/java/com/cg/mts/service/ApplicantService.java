package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Applicant;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.exceptions.DuplicateDataException;
import com.cg.mts.repository.IApplicantRepository;
@Service
public class ApplicantService implements IApplicantService{
	
	@Autowired
	IApplicantRepository repository;
	
	public void addApplicant(Applicant applicant) throws DuplicateDataException {
		if(repository.existsById(applicant.getApplicantId()))
			throw new DuplicateDataException("Applicant with id "+applicant.getApplicantId()+" already exists!..");
		repository.save(applicant);
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
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		} 
		else {
		 return false;
		}
	}
	public Applicant viewApplicant(int id) {
		Optional<Applicant> opt=repository.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}
	
	@Override
	public List<Applicant> getBtechDegree(){
		List<Applicant> degree=(List<Applicant>)repository.getBtechDegree();
		return degree;
	}
	/*public List<Applicant> findAll(){
	
		return em.createQuery("select r.status from Admission r join Applicant c on r.applicantId = c.applicantId",Applicant.class).getResultList();
		 
	}*/
}
