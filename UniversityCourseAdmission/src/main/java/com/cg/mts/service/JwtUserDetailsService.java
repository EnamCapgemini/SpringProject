package com.cg.mts.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.mts.config.JwtTokenUtil;
import com.cg.mts.entities.DAOUser;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.model.PasswordDTO;
import com.cg.mts.model.UserDTO;
import com.cg.mts.repository.UserDao;

@Service()
public class JwtUserDetailsService implements UserDetailsService,IJwtUserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		return new User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	@Override
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}
	
	@Override
	public void logIn(String username) {
		DAOUser user = userDao.findByUsername(username);
		user.setLoggedIn(true);
		userDao.save(user);
	}
	
	@Override
	public boolean logOut(String userName) {
		DAOUser existUser = userDao.findByUsername(userName);
		
		if(existUser == null) {
			throw new DataNotFoundException("Logout", "Username: '"+userName+"' not found!");
		}
		
		if(existUser.isLoggedIn()) {
			existUser.setLoggedIn(false);
			userDao.save(existUser);
			
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean changePassword(String userName, PasswordDTO passwordDTO) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(userName);
		if(user == null) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
		
		if(bcryptEncoder.matches(passwordDTO.getOldPassword(), user.getPassword()) && user.isLoggedIn()) {
			user.setPassword(bcryptEncoder.encode(passwordDTO.getNewPassword()));
			userDao.save(user);
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public String getUserNameToken(String token) {
		String jwtToken = token.substring(7);
		String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
		return userName;
	}
	
	
	@Override
	public String getRoleFromToken(String token) throws UsernameNotFoundException {
		String jwtToken = token.substring(7);
		String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
		DAOUser user = userDao.findByUsername(userName);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
		
		return user.getRole();
	}
	
	@Override
	public DAOUser getUserDetailsFromToken(String token) throws UsernameNotFoundException {
		String jwtToken = token.substring(7);
		String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
		DAOUser user = userDao.findByUsername(userName);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
		
		return userDao.findByUsername(userName);
	}
	
	
}