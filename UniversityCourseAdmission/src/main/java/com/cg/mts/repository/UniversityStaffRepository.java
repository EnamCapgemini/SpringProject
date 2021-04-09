package com.cg.mts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.UniversityStaffMember;

@Repository
public interface UniversityStaffRepository extends CrudRepository<UniversityStaffMember, Integer>{

}
