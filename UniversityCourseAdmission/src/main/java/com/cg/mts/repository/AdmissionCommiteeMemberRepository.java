package com.cg.mts.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.AdmissionCommiteeMember;

@Repository
public interface AdmissionCommiteeMemberRepository extends CrudRepository<AdmissionCommiteeMember, Integer> {

	AdmissionCommiteeMember findByAdmissionCommiteeMemberId(int admissionCommiteeMemberId);

	boolean existsByAdmissionCommiteeMemberId(int admissionCommiteeMemberId);

	@Modifying
	@Query(value = "delete from ADMISSION_COMMITEE_MEMBER acm where acm.ADMISSION_COMMITEE_MEMBER_ID = ?1", nativeQuery = true)
	void deleteByAdmissionCommiteeMemberId(int admissionCommiteeMemberId);
}
