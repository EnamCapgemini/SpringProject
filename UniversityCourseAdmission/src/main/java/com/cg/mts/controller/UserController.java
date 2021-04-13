package com.cg.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.model.UserModel;
import com.cg.mts.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> singIn(@RequestBody UserModel user) {
		
		if(service.signIn(user)) {
			return new ResponseEntity<>("User Login successful!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("UserName or Password not match!", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/logout/{name}")
	public ResponseEntity<?> logOut(@PathVariable("name") String userName) {
		
		if(service.logOut(userName)) {
			return new ResponseEntity<>("User Logout successful!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Please login first!", HttpStatus.BAD_REQUEST);
		}
	}

}
