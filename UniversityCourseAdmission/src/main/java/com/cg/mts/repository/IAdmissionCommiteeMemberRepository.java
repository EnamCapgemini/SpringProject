package com.cg.mts.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.AdmissionCommiteeMember;

@Repository
public interface IAdmissionCommiteeMemberRepository extends JpaRepository<AdmissionCommiteeMember, Integer> {

	AdmissionCommiteeMember findByAdmissionCommiteeMemberId(int admissionCommiteeMemberId);

	boolean existsByAdmissionCommiteeMemberId(int admissionCommiteeMemberId);

	
//	@Query("Delete from AdmissionCommiteeMember acm where acm.admissionCommiteeMemberId = ?1")
//	void deleteByAdmissionCommiteeMemberId(int admissionCommiteeMemberId);
	
//	@Query("Select a.status from Admission a,Applicant ap where a.applicantId=:id and ap.applicantGraduationPercent=:grad")
//	String getStatusById(@Param("id")int id,@Param("grad")int grad);
	

	//@Modifying
	//@Transactional
	//@Query("delete from AdmissionCommiteeMember where admissionCommiteeMemberId=?1")
	//int deleteByAdmissionCommittee(int acmid);

}
