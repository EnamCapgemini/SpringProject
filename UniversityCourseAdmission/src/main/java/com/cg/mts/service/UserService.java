package com.cg.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.User;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.model.UserModel;
import com.cg.mts.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	

	public ResponseEntity<?> signIn(UserModel user) {
		
		User existUser = repository.findByUserName(user.getUserName());
		
		if(existUser == null) {
			throw new DataNotFoundException("Login", "Username: '"+user.getUserName()+"' not found!");
		}
		
		if(existUser.getUserName().equals(user.getUserName()) && existUser.getPassword().equals(user.getPassword())) {
			existUser.setLoggedIn(true);
			repository.save(existUser);
			
			return new ResponseEntity<>("User Login successful!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("UserName or Password not match!", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	public ResponseEntity<?> logOut(String userName) {
		
		User existUser = repository.findByUserName(userName);
		
		if(existUser == null) {
			throw new DataNotFoundException("Logout", "Username: '"+userName+"' not found!");
		}
		
		if(existUser.isLoggedIn()) {
			existUser.setLoggedIn(false);
			repository.save(existUser);
			
			return new ResponseEntity<>("User Logout successful!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Please login first!", HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
