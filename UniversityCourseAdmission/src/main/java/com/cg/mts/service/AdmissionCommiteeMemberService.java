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
//import com.cg.mts.exceptions.DuplicateAdmissionCommiteeMemberException;
import com.cg.mts.exceptions.DuplicateDataException;
import com.cg.mts.repository.AdmissionCommiteeMemberRepository;

@Component
public class AdmissionCommiteeMemberService implements IAdmissionCommiteeMemberService {

	@Autowired
	
	AdmissionCommiteeMemberRepository repository;

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

	@Transactional
	public boolean deleteAdmissionCommiteeMember(int id) {
		if (repository.existsByAdmissionCommiteeMemberId(id)) {
			repository.deleteByAdmissionCommiteeMemberId(id);
			return true;
		}
		return false;
	}

	@Override
	public void provideAdmissionResult(Applicant ap, Admission ad) {
		
		if(ap.getApplicantGraduationPercent() > 60) {
			ad.setStatus(AdmissionStatus.CONFIRMED);
		}else {
			ad.setStatus(AdmissionStatus.REJECTED);
		}
	}

}