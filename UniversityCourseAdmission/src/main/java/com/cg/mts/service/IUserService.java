package com.cg.mts.service;

import com.cg.mts.model.UserModel;

public interface IUserService {
	
	boolean signIn(UserModel userModel);
	boolean logOut(String userName);

}
