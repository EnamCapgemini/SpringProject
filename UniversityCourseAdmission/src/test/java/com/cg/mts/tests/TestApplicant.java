package com.cg.mts.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.Admission;
import com.cg.mts.entities.Gender;
import com.cg.mts.repository.IApplicantRepository;
import com.cg.mts.service.ApplicantService;

@SpringBootTest
class TestApplicant {

	@Autowired
	private ApplicantService service;

	@MockBean
	private IApplicantRepository repository;
	
	
	@Test
	public void addApplicant() {
		Applicant applicant=new Applicant(5500,"pritam","das","9874563210",300,null,"b.tech",70,Gender.MALE,"dubrajpur","asd@gmail.com");
		when(repository.save(applicant)).thenReturn(applicant);
		assertEquals(applicant, repository.save(applicant));
	}
	
	/*@Test
	public void viewApplicant() {
		Admission a=new Admission(10,220,550,LocalDate.now(),AdmissionStatus.APPLIED);
		Applicant applicant=new Applicant(550,"pritam","das","9874563210",300,a,"b.tech",70,Gender.MALE,"dubrajpur","asd@gmail.com");
		assertEquals(applicant,service.viewApplicant(550));
	}*/
	@Test
	public void updateApplicant() {
		Applicant applicant=new Applicant(5500,"pritam","das","9874563210",300,null,"b.tech",70,Gender.MALE,"dubrajpur","asd@gmail.com");
		when(repository.save(applicant)).thenReturn(applicant);
		applicant=new Applicant(5500,"pritam","das","9870063210",300,null,"b.tech",60,Gender.MALE,"bakura","asd@gmail.com");
		assertNotEquals(applicant, repository.save(applicant));
	}
	
	@Test
	public void deleteApplicant() {
		Applicant applicant=new Applicant(5500,"pritam","das","9874563210",300,null,"b.tech",70,Gender.MALE,"dubrajpur","asd@gmail.com");
		assertNotEquals(applicant, service.deleteApplicant(5500));
	}
}
