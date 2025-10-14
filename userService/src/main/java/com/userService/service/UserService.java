package com.userService.service;

import java.util.List;

import com.userService.entity.User;

public interface UserService {

	
	
	//for saving the user
	User saveUser(User user);
	
	
	//to get all user
	public List<User> getAllUser();

	
//	to get single user

	public User getUser(String useriId);
	
//	to delete user
	
	public String deleteUser(String useriId);

// to update the user
	public User updateUser(User user);


}