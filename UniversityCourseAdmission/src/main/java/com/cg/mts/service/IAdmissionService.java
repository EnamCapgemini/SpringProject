package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Admission;

public interface IAdmissionService {
	
	void addAdmission(Admission a);
	boolean updateAdmission(Admission a);
	boolean deleteAdmission(int id);
	Admission getAdmission(int id);
	List<Admission> showAllByDate(String adDate);

}
