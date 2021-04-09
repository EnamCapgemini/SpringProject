package com.cg.mts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Applicant;
@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Integer> {

}
