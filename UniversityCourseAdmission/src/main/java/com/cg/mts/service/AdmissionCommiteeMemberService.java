package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.exceptions.DataNotFoundException;
//import com.cg.mts.exceptions.DuplicateAdmissionCommiteeMemberException;
import com.cg.mts.exceptions.DuplicateDataException;
import com.cg.mts.repository.IAdmissionCommiteeMemberRepository;
import com.cg.mts.repository.IAdmissionRepository;

@Component
public class AdmissionCommiteeMemberService implements IAdmissionCommiteeMemberService {

	@Autowired
	
	IAdmissionCommiteeMemberRepository repository;

	@Autowired
	
	IAdmissionRepository repo;
	
	public void saveAdmissionCommiteeMember(AdmissionCommiteeMember e) {

		if (repository.existsById(e.getAdmissionCommiteeMemberId())) {
			throw new DuplicateDataException(
					"Admission Commitee Member with id : " + e.getAdmissionCommiteeMemberId() + " already exists.");
		}
		repository.save(e);
	}

	public AdmissionCommiteeMember getUserbyAdmissionCommiteeMemberId(int id) {
		return repository.findByAdmissionCommiteeMemberId(id);
	}

	public AdmissionCommiteeMember getAdmissionCommiteeMember(int id) {
		Optional<AdmissionCommiteeMember> opt = repository.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	public List<AdmissionCommiteeMember> getAllAdmissionCommiteeMembers() {
		List<AdmissionCommiteeMember> list = (List<AdmissionCommiteeMember>) repository.findAll();
		return list;
	}

	public boolean updateAdmissionCommiteeMember(AdmissionCommiteeMember e) {
		if (repository.existsByAdmissionCommiteeMemberId(e.getAdmissionCommiteeMemberId())) {
			repository.save(e);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAdmissionCommiteeMember(int id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			
			return true;
		}
		return false;
	}

	@Override
	public boolean provideAdmissionResult(int adid, AdmissionStatus as) {
		
		if(!(repo.existsById(adid))) {
			throw new DataNotFoundException("update","Admission with id "+adid+" not found...");
		}
		else {
			Admission ad = repo.findById(adid).get();
			ad.setStatus(as);
			repo.save(ad);
			return true;
		}
	}
	
	
	
//	@Override
//	public String getStatusByIdGrad(int id,int grad) {
//		String status=repository.getStatusById(id, grad);
//		
//		return status;
//	}

}