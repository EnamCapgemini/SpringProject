package com.cg.mts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Admission;
import com.cg.mts.exceptions.AdmissionIdNotFoundException;
import com.cg.mts.exceptions.DuplicateAdmissionException;
import com.cg.mts.repository.AdmissionRepository;

@Service
public class AdmissionService {
	
	@Autowired
	AdmissionRepository repository;
	
	public void addAdmission(Admission a) throws DuplicateAdmissionException{
		if(repository.existsById(a.getAdmissionId()))
			throw new DuplicateAdmissionException("Admission with" +a.getAdmissionId() +"already exists...");
		repository.save(a);
	}
	
	public boolean updateAdmission(Admission a) {
		if(!(repository.existsById(a.getAdmissionId()))) {
			throw new AdmissionIdNotFoundException("Admission with id"+a.getAdmissionId()+"not found...");
		}
		else {
			repository.save(a);
			return true;
		}
	}
	
	public boolean deleteAdmission(int id) {
		if(!(repository.existsById(id))) {
			throw new AdmissionIdNotFoundException("Admission with id"+id+"not found...");
		}
		else {
			repository.deleteById(id);
			return true;
		}
	}
	
	public Admission getAdmission(int id) {
	       
        Optional<Admission> opt = repository.findById(id);
        if(opt.isPresent())
            return opt.get();
        return null;
    } 

}
