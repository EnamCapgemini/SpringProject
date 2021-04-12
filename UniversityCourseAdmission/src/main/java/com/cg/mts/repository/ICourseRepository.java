package com.cg.mts.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Course;

@Repository
public interface ICourseRepository extends CrudRepository<Course, Integer> {

}