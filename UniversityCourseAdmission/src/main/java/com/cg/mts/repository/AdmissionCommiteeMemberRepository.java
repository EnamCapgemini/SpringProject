package com.cg.mts.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.AdmissionCommiteeMember;

@Repository
public interface AdmissionCommiteeMemberRepository extends CrudRepository<AdmissionCommiteeMember, Integer>{

	AdmissionCommiteeMember findByAdmissionCommiteeMemberId(int admissionCommiteeMemberId);
	boolean existsByAdmissionCommiteeMemberId(int admissionCommiteeMemberId);
}
