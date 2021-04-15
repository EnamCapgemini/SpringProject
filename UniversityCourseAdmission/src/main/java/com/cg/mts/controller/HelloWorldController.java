package com.cg.mts.controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.config.JwtTokenUtil;



@RestController
public class HelloWorldController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@GetMapping({ "/hello" })
	public String firstPage(@RequestHeader("Name") String name) {
		//String jwtToken = token.substring(7);
		//String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
		//Date expirationDate = jwtTokenUtil.getExpirationDateFromToken(jwtToken);
		return "Hello "+name;
	}
	
	@GetMapping("/date") 
	public LocalDate getDate() {
		return LocalDate.now();
	}
	
	@GetMapping("/home") 
	public String getHome() {
		return "Welcome to Home";
	}
	
	@GetMapping("/sensitive")
	public String getSensitive(@RequestHeader("Authorization") String token) {
		String jwtToken = token.substring(7);
		String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
		Date expirationDate = jwtTokenUtil.getExpirationDateFromToken(jwtToken);
		return "Sensitive informations: UserName="+userName+" , expirationDate="+expirationDate;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@RequestHeader("Authorization") String token, @PathVariable("id") int userId) {
		return "user with id: "+userId+" is deleted";
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUsers(@RequestHeader("Authorization") String token) {
		return "user is deleted";
	}

}