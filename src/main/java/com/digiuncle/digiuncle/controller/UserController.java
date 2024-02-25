package com.digiuncle.digiuncle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digiuncle.digiuncle.entity.Users;
import com.digiuncle.digiuncle.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/mobile/{mobile}")
	public ResponseEntity<?> getUserByMobile(@PathVariable String mobile){
		Users user = userService.getUserByMobile(mobile);
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User not found with the mobile number" + mobile, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> getUserByEmail(@PathVariable String email){
		Users user = userService.getUserByEmail(email);
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User not found with the email " + email, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add-user")
	public ResponseEntity<String> saveUsers(@RequestBody Users users){
		try {
			userService.saveUsers(users);
			return new ResponseEntity<>("User added successfully ", HttpStatus.CREATED);
		} catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> authenticateUser(@RequestBody Users user){
		boolean authenticated = userService.authenticateUser(user.getEmail(), user.getPassword());
		if (authenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
	}
	
	
}

