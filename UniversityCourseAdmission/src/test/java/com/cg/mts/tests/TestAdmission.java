package com.cg.mts.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.repository.AdmissionRepository;
import com.cg.mts.service.AdmissionService;

@SpringBootTest
class TestAdmission {
	
	@Autowired
	private AdmissionService service;
	
	@MockBean
	private AdmissionRepository repository;

	@Test
	public void addAdmission() {
		Admission a = new Admission(100,1000,2000,LocalDate.now(),AdmissionStatus.PENDING);
		when(repository.save(a)).thenReturn(a);
		assertEquals(a, repository.save(a));
	}
	
	@Test
	public void updateAdmission() {
		Admission a = new Admission(100,1000,2000,LocalDate.now(),AdmissionStatus.PENDING);
		when(repository.save(a)).thenReturn(a);
		a = new Admission(100,1000,200,LocalDate.now(),AdmissionStatus.APPLIED);
		assertNotEquals(a,repository.save(a));
	}
	
	@Test
	public void deleteAdmission() {
		Admission a = new Admission(100,1000,2000,LocalDate.now(),AdmissionStatus.PENDING);
		assertNotEquals(a,service.deleteAdmission(100));
	}
	
}