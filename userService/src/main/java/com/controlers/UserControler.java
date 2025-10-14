package com.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userService.entity.User;
import com.userService.service.ImpUserService;
import com.userService.service.UserService;

@RestController
@RequestMapping("/users")
public class UserControler {
	
	@Autowired
UserService userService;
	
	@PostMapping
	ResponseEntity<User> createUser(@RequestBody User user){
		System.out.println("-------------------------------------");
		User saveUser = userService.saveUser(user);
	
	return	ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	
	}
	
	@GetMapping
	ResponseEntity<List<User>> getAllUser(){
		
		List<User> saveUser = userService.getAllUser();
	
	return	ResponseEntity.ok(saveUser);
	}
	
	
	@GetMapping("/{userId}")
	ResponseEntity<User> getUser(@PathVariable String userId){
		System.out.println("get user method is calling");
		User saveUser = userService.getUser(userId);
	
	return	ResponseEntity.ok(saveUser);
	}
	
	@GetMapping("/test")
    public String testServer() {
		System.out.println("hello shawaiz");
        return "Server OK ";
    }
}
