package com.cg.mts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Admission;
import com.cg.mts.exceptions.DuplicateAdmissionException;
import com.cg.mts.repository.AdmissionRepository;

@Service
public class AdmissionService {
	
	@Autowired
	AdmissionRepository repository;
	
	public Admission get(int id) {
	       
        Optional<Admission> opt = repository.findById(id);
        if(opt.isPresent())
            return opt.get();
        return null;
    } 

}
