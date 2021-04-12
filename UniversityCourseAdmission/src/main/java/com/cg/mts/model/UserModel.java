package com.cg.mts.model;

import com.cg.mts.entities.User;

public class UserModel {

	private String userName;
	private String password;
	
	public UserModel() {
		
	}
	
	public UserModel(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static UserModel toUserModel(User user) {
		
		UserModel userModel = new UserModel();
		userModel.setUserName(user.getUserName());
		userModel.setPassword(user.getPassword());
		
		return userModel;
	}
}
