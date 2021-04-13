package com.cg.mts.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
=======
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

>>>>>>> 99e6feaacbd7c53cd68eb3873e6c765f748a3696
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;

@Repository
<<<<<<< HEAD
public interface ICourseRepository extends JpaRepository<Course, Integer> {

	
	
}
=======
public interface ICourseRepository extends CrudRepository<Course, Integer> {
	

 /*   @Query("select c from Course c where c.courseName like b%")
    List<Course> findBystartsEndsWith();
*/}
>>>>>>> 99e6feaacbd7c53cd68eb3873e6c765f748a3696
