package com.cg.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.User;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.model.UserModel;
import com.cg.mts.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository repository;

	@Override
	public boolean signIn(UserModel user) {
		
		User existUser = repository.findByUserName(user.getUserName());
		
		if(existUser == null) {
			throw new DataNotFoundException("Login", "Username: '"+user.getUserName()+"' not found!");
		}
		
		if(existUser.getUserName().equals(user.getUserName()) && existUser.getPassword().equals(user.getPassword())) {
			existUser.setLoggedIn(true);
			repository.save(existUser);
			
			return true;
		}
		else {
			return false;
		}
		
	}
	
	@Override
	public boolean logOut(String userName) {
		
		User existUser = repository.findByUserName(userName);
		
		if(existUser == null) {
			throw new DataNotFoundException("Logout", "Username: '"+userName+"' not found!");
		}
		
		if(existUser.isLoggedIn()) {
			existUser.setLoggedIn(false);
			repository.save(existUser);
			
			return true;
		}
		else {
			return false;
		}
	}
	
	

}
