package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.exceptions.DuplicateAdmissionCommiteeMemberException;
import com.cg.mts.repository.AdmissionCommiteeMemberRepository;

@Service
public class AdmissionCommiteeMemberService {

	@Autowired
	AdmissionCommiteeMemberRepository repository;

	public void saveAdmissionCommiteeMember(AdmissionCommiteeMember e) {

		if (repository.existsById(e.getAdmissionCommiteeMemberId())) {
			throw new DuplicateAdmissionCommiteeMemberException(
					"Admission Commitee Member with id : " + e.getAdmissionCommiteeMemberId() + " already exists.");
		}
		repository.save(e);
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
		if (repository.existsById(e.getStaffId())) {
			repository.save(e);
			return true;
		}
		return false;
	}

	public boolean deleteAdmissionCommiteeMember(int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}