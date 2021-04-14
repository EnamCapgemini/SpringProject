package com.cg.mts.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.repository.IUniversityStaffRepository;
import com.cg.mts.service.UniversityStaffService;



@SpringBootTest
class TestUniversityStaffMember {

	@Autowired
	private UniversityStaffService service;
	
	@MockBean
	private IUniversityStaffRepository repository;
	
	@Test
	public void getAllStaffsTest() {
		when(repository.findAll()).thenReturn(Stream.of(new UniversityStaffMember(999, "Fsk@78SS", "Teacher"),new UniversityStaffMember(888, "Sup_98sgys", "librarian")).collect(Collectors.toList()));
		assertEquals(2, service.viewAllStaffs().size());
	}
	
	@Test
	public void getStaffTest() {
		UniversityStaffMember staff= new UniversityStaffMember(700,"Supratim@5467","Dean");
		when(repository.findById(700)).thenReturn(Optional.of(staff));
		UniversityStaffMember expectedStaff=service.viewStaff(staff.getStaffId());
		assertThat(expectedStaff).isSameAs(staff);
		verify(repository).findById(staff.getStaffId());
	}
	
	@Test
	public void saveStaffTest() {
		UniversityStaffMember staff=new UniversityStaffMember(700,"Supratim@5467","Dean");
		when(repository.save(staff)).thenReturn(staff);
		assertEquals(staff, repository.save(staff));
	}
	
	@Test
	public void updateStaffTest() {
		UniversityStaffMember staff=new UniversityStaffMember(700,"Supratim@5467","Dean");
		when(repository.save(staff)).thenReturn(staff);
		staff.setRole("faculty");
		assertThat(repository.findById(staff.getStaffId())).isNotEqualTo(staff);
	}
	
	@Test
	public void deleteStaffTest() {
		UniversityStaffMember staff=new UniversityStaffMember(700,"Supratim@5467","Dean");
		when(repository.existsById(staff.getStaffId())).thenReturn(true);
		service.removeStaff(staff.getStaffId());
		verify(repository).deleteById(700);
		
		//assertNotEquals(staff, service.removeStaff(700));
	}

}
