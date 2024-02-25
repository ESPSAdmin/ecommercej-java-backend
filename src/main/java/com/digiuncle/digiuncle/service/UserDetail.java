package com.digiuncle.digiuncle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiuncle.digiuncle.entity.Users;
import com.digiuncle.digiuncle.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetail implements UserService {
	@Autowired
	private final UserRepository userRepository;
	
	@Autowired
	public UserDetail(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void saveUsers(Users users) {
		Users existUserWithEmail = userRepository.getUserByEmail(users.getEmail());
		if(existUserWithEmail != null) {
			throw new RuntimeException("User with the same email already exists");
		}
		
		Users existUserWithMobile = userRepository.getUserByMobile(users.getMobile());
		if(existUserWithMobile != null) {
			throw new RuntimeException("User with the same Mobile already exists");
		}
		
		userRepository.save(users);
	}
	
	@Override
	public Users getUserByMobile(String mobile) {
		return userRepository.getUserByMobile(mobile);
	}
	
	@Override
	public Users getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	};
	
	@Override
	public boolean authenticateUser(String email, String password) {
		Users user = userRepository.getUserByEmail(email);
		return user != null && user.getPassword().equals(password);
	};
	
}
