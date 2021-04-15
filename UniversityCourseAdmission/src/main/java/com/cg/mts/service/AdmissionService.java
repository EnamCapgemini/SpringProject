package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Admission;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.exceptions.DuplicateDataException;
import com.cg.mts.repository.IAdmissionRepository;

@Service
public class AdmissionService implements IAdmissionService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	IAdmissionRepository repository;

	public void addAdmission(Admission a) throws DuplicateDataException {
		if (repository.existsById(a.getAdmissionId()))
			throw new DuplicateDataException("Admission with" + a.getAdmissionId() + "already exists...");
		repository.save(a);
	}

	public boolean updateAdmission(Admission a) {
		if (!(repository.existsById(a.getAdmissionId()))) {
			throw new DataNotFoundException("update", "Admission with id" + a.getAdmissionId() + "not found...");
		} else {
			repository.save(a);
			return true;
		}
	}

	public boolean deleteAdmission(int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Admission getAdmission(int id) {

		Optional<Admission> opt = repository.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	public List<Admission> showAllByDate(String adDate) {
		return em.createQuery("Select a from Admission a where a.admissionDate = '" + adDate + "'", Admission.class)
				.getResultList();
	}
	
	public List<Admission> showAllByCourseId(int id) {
		return em.createQuery("Select a from Admission a where a.courseId = '" + id + "'", Admission.class)
				.getResultList();
	}

}
