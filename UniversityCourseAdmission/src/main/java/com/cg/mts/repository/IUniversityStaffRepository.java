package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;

@Repository
public interface IUniversityStaffRepository extends CrudRepository<UniversityStaffMember, Integer>{

	
	
}
