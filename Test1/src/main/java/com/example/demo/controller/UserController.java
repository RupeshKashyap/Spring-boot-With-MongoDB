package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Test1Application;
import com.example.demo.dal.UserRepository;
import com.example.demo.modal.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="User Information", description = "User Information")
@RequestMapping(value = "/api")
public class UserController {
	private static final Logger logger = LogManager.getLogger(Test1Application.class);
	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@ApiOperation(value = "Get AllUsers")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		logger.info("Getting all users.");
		System.out.println("find all ececuting");
		return userRepository.findAll();
	}

	@ApiOperation(value = "Get Single User")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable String userId) {
		logger.info("Getting user with ID: {}.", userId);
		
		return userRepository.findById(userId);
	}
	
	@ApiOperation(value = "Create New user")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewUsers(@RequestBody User user) {
		logger.info("Saving user.");
		System.out.println("executing");
		 userRepository.save(user);
		 return new ResponseEntity<>("User is Create successfully", HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Delete a User")
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable String userId) {
		logger.info("Getting user with ID: {}.", userId);
		userRepository.deleteById(userId);
		return new ResponseEntity<>("User is Delete successfully", HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update a User")
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@PathVariable("id") String userId,@RequestBody User user) {
		
		userRepository.deleteById(userId);
		user.setUserId(userId);
		userRepository.save(user);
		
		return new ResponseEntity<>("User is updated successfully", HttpStatus.CREATED);
	}
	
	

}
