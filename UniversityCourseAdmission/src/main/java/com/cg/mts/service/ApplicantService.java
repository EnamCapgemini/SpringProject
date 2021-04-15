package com.cg.mts.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.DAOUser;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.exceptions.DuplicateDataException;
import com.cg.mts.repository.IApplicantRepository;
import com.cg.mts.repository.UserDao;
@Service
public class ApplicantService implements IApplicantService{
	
	@Autowired
	IApplicantRepository repository;
	
	@Autowired
	UserDao userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	public void addApplicant(Applicant applicant) throws DuplicateDataException {
		if(repository.existsById(applicant.getApplicantId()))
			throw new DuplicateDataException("Applicant with id "+applicant.getApplicantId()+" already exists!..");
		
		// User is added here in User table
		DAOUser newUser = new DAOUser();
		newUser.setUsername(applicant.getUsername());
		newUser.setPassword(bcryptEncoder.encode(applicant.getPassword()));
		newUser.setRole("APPLICANT");
		newUser.setLoggedIn(true);
		userRepository.save(newUser);
		
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
	public List<Applicant> get12thpass(){
		List<Applicant> degree=(List<Applicant>)repository.get12thpass();
		return degree;
	}
	
	@Override
	public List<Applicant> getBtechDegree(){
		List<Applicant> degree=(List<Applicant>)repository.getBtechDegree();
		return degree;
	}
	
	@Override
	public List<Applicant> showAll1stDivision(){
		List<Applicant> per=(List<Applicant>)repository.showAll1stDivision();
		return per;
	}
	
	@Override
	public List<Applicant> showMaleApplicants(){
		List<Applicant> male=(List<Applicant>)repository.showMaleApplicants();
		return male;
	}
	@Override
	public List<Applicant> showFemaleApplicants(){
		List<Applicant> female=(List<Applicant>)repository.showFemaleApplicants();
		return female;
	}

}
