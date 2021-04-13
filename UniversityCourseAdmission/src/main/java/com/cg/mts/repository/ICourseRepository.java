package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Course;

@Repository
public interface ICourseRepository extends CrudRepository<Course, Integer> {
	

    @Query("select c from Course c where c.courseName like b%")
    List<Course> findBystartsEndsWith();
}