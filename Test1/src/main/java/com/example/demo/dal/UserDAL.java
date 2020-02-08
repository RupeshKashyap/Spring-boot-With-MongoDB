package com.example.demo.dal;

import java.util.List;

import com.example.demo.modal.User;

public interface	 UserDAL {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);
	
}
