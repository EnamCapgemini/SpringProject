package com.cg.mts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.Applicant;
@Service
public interface IAdmissionCommiteeMemberService {

	void saveAdmissionCommiteeMember(AdmissionCommiteeMember e);
	AdmissionCommiteeMember getUserbyAdmissionCommiteeMemberId(int id);
	AdmissionCommiteeMember getAdmissionCommiteeMember(int id);
	List<AdmissionCommiteeMember> getAllAdmissionCommiteeMembers();
	boolean updateAdmissionCommiteeMember(AdmissionCommiteeMember e);
	//boolean deleteAdmissionCommiteeMember(int id);
	void provideAdmissionResult(Applicant ap, Admission ad);

//	String getStatusByIdGrad(int id,int grad);
}
