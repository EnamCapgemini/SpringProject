package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Applicant;

public interface IApplicantService {
	void addApplicant(Applicant applicant);
	boolean updateApplicant(Applicant applicant);
	boolean deleteApplicant(int id);
	Applicant viewApplicant(int id);
	List<Applicant> getBtechDegree();
}
