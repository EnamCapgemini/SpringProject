package com.cg.mts.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.repository.IAdmissionCommiteeMemberRepository;
import com.cg.mts.service.AdmissionCommiteeMemberService;

@SpringBootTest
class TestAdmissionCommiteeMember {

	@Autowired
	private AdmissionCommiteeMemberService service;

	@MockBean
	private IAdmissionCommiteeMemberRepository repository;

	@Test
	public void getAllAdmissionCommiteeMembersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new AdmissionCommiteeMember(5000, "Satish", "satish.pandey@capgemini.com"),
						new AdmissionCommiteeMember(6000, "Aaryan", "aaryan.gill@capgemini.com"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllAdmissionCommiteeMembers().size());
	}

	@Test
	public void saveMemberTest() {
		AdmissionCommiteeMember member = new AdmissionCommiteeMember(8000, "Kabran", "kabran.khan@capgemini.com");
		when(repository.save(member)).thenReturn(member);
		assertEquals(member, repository.save(member));
	}

	@Test
	public void updateMemberTest() {
		AdmissionCommiteeMember member = new AdmissionCommiteeMember(8000, "Kabran", "kabran.khan@capgemini.com");
		when(repository.save(member)).thenReturn(member);
		member = new AdmissionCommiteeMember(8000, "Kabran", "kabran123.khan@capgemini.com");
		assertNotEquals(member, repository.save(member));
	}

	@Test
	public void deleteMemberTest() {
		AdmissionCommiteeMember member = new AdmissionCommiteeMember(8000, "Kabran", "kabran.khan@capgemini.com");
		// service.removeMember(member.getAdmissionCommiteeMemberId());
		assertNotEquals(member, service.deleteAdmissionCommiteeMember(8000));
	}

}
