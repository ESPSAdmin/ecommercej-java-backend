package com.digiuncle.digiuncle.service;

import com.digiuncle.digiuncle.entity.Users;

public interface UserService {
	public void saveUsers(Users users);
	
	Users getUserByMobile(String mobile);
	
	Users getUserByEmail(String email);
	
	boolean authenticateUser(String email, String password);
}
