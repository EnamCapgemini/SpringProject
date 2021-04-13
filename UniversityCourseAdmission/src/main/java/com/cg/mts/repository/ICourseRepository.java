package com.cg.mts.repository;

import java.util.List;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
=======
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
>>>>>>> 8481f0a2833765328a2cc9c1a803eccc02272c22

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Course;

@Repository
public interface ICourseRepository extends CrudRepository<Course, Integer> {
	

<<<<<<< HEAD
    @Query("select c from Course c where c.courseName like b%")
    List<Course> findBystartsEndsWith();
=======

	
>>>>>>> 8481f0a2833765328a2cc9c1a803eccc02272c22
}