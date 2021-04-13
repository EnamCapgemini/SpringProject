package com.cg.mts.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.cg.mts.entities.User;
import com.cg.mts.model.UserModel;
import com.cg.mts.repository.UserRepository;
import com.cg.mts.service.UserService;


@SpringBootTest
class TestUserLogin {

	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void saveUserTest() {
		User user = new User("Paul","pass@707","admin",true);
		User ret = repository.save(user);
		assertSame(user, ret);
	}
	
	@Test
	public void userLoginTest() {
		UserModel userModel = new UserModel("root", "pass@123");
		assertEquals(HttpStatus.OK,service.signIn(userModel).getStatusCode());
	}
	
	@Test
	public void loginWithInvalidPasswordTest() {
		UserModel userModel = new UserModel("root", "pass@651");
		
		assertEquals(HttpStatus.BAD_REQUEST,service.signIn(userModel).getStatusCode());
	}
	
	@Test
	public void loginWithInvalidUserNameTest() {
		assertNull(repository.findByUserName("wrong"));
	}

}
