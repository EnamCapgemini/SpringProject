package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Applicant;
@Repository
public interface IApplicantRepository extends CrudRepository<Applicant, Integer> {

    @Query("select d from Applicant d where d.applicantDegree like 'B.Tech%' ")
    List<Applicant> getBtechDegree();
}
