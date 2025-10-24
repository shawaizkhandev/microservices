package com.controlers;

import java.util.List;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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
	
int retryCount = 0;
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallbackMethod")
	@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallbackMethod")
	ResponseEntity<User> getUser(@PathVariable String userId){
		System.err.println("-------------"+retryCount++);
		System.out.println("get user method is calling");
		User saveUser = userService.getUser(userId);
	
	return	ResponseEntity.ok(saveUser);
	}

	ResponseEntity<User> ratingHotelFallbackMethod(String userId,Exception e) {
		System.err.println("rating hotel fallback method is called because service is down : "+e.getMessage());
	User dummy = User.builder().userAbout("dummy").userName("dummy name").build();
	return ResponseEntity.ok(dummy);
	}

	
	@GetMapping("/test")
    public String testServer() {
		System.out.println("hello shawaiz");
        return "Server OK ";
    }
}
