package com.cg.mts.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.repository.ICourseRepository;
import com.cg.mts.repository.IUniversityStaffRepository;
import com.cg.mts.service.UniversityStaffService;



@SpringBootTest
class TestUniversityStaffMember {

	@Autowired
	private UniversityStaffService service;
	
	@MockBean
	private IUniversityStaffRepository repository;
	
	@MockBean
	private ICourseRepository courseRepo;
	
	Logger logger=LoggerFactory.getLogger(TestUniversityStaffMember.class);
	
	@Test
	public void getAllStaffsTest() {
		logger.info("Testing for getAllStaffs Started");
		when(repository.findAll()).thenReturn(Stream.of(new UniversityStaffMember(999, "Fsk@78SS", "Teacher"),new UniversityStaffMember(888, "Sup_98sgys", "librarian")).collect(Collectors.toList()));
		assertEquals(2, service.viewAllStaffs().size());
		logger.info("Testing for getAllStaffs Completed");
	}
	
	@Test
	public void getStaffTest() {
		logger.info("Testing for getStaff Started");
		UniversityStaffMember staff= new UniversityStaffMember(700,"Supratim@5467","Dean");
		when(repository.findById(700)).thenReturn(Optional.of(staff));
		UniversityStaffMember expectedStaff=service.viewStaff(staff.getStaffId());
		assertThat(expectedStaff).isSameAs(staff);
		verify(repository).findById(staff.getStaffId());
		logger.info("Testing for getStaff Completed");
	}
	
	@Test
	public void saveStaffTest() {
		logger.info("Testing for SaveStaff Started");
		UniversityStaffMember staff=new UniversityStaffMember(700,"Supratim@5467","Dean");
		when(repository.save(staff)).thenReturn(staff);
		assertEquals(staff, repository.save(staff));
		logger.info("Testing for SaveStaff Completed");
	}
	
	@Test
	public void updateStaffTest() {
		logger.info("Testing for updateStaff Started");
		UniversityStaffMember staff=new UniversityStaffMember(700,"Supratim@5467","Dean");
		when(repository.save(staff)).thenReturn(staff);
		staff.setRole("faculty");
		assertThat(repository.findById(staff.getStaffId())).isNotEqualTo(staff);
		logger.info("Testing for updateStaff Completed");
	}
	
	@Test
	public void deleteStaffTest() {
		logger.info("Testing for deleteStaffs Started");
		UniversityStaffMember staff=new UniversityStaffMember(700,"Supratim@5467","Dean");
		when(repository.existsById(staff.getStaffId())).thenReturn(true);
		service.removeStaff(staff.getStaffId());
		verify(repository).deleteById(700);
		
		//assertNotEquals(staff, service.removeStaff(700));
		logger.info("Testing for deleteStaffs Completed");
	}

	/*
	@Test
	public void addCourse() {
		logger.info("Testing for SaveCourse From StaffClass Started");
		Course course1=new Course(500, "MCA", "3 YEARS", LocalDate.now(), LocalDate.now().plusYears(3), "950000");
		when(courseRepo.save(course1)).thenReturn(course1);
		assertEquals(course1, courseRepo.save(course1));
		logger.info("Testing for SaveCourse From StaffClass Completed");
		
	}
	
	@Test
	public void updateCourse() {
		logger.info("Testing for UpdateCourse From StaffClass Started");
		Course course1=new Course(500, "MCA", "3 YEARS", LocalDate.now(), LocalDate.now().plusYears(3), "950000");
		when(courseRepo.save(course1)).thenReturn(course1);
		course1.setCourseFees("900000");
		course1.setCourseName("ph.D");
		assertThat(courseRepo.findById(course1.getCourseId())).isNotEqualTo(course1);
		logger.info("Testing for UpdateCourse From StaffClass Completed");
	}
	
	*/

}
