package com.userService;

import com.userService.entity.Rating;
import com.userService.external.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

@Autowired
	RatingService ratingService;

	@Test
	void createRating(){
		Rating rating = Rating.builder().userId("c8130a8e-3090-4f0b-98c7-548a5cadba8e").rating(4).feedback("feedback is good").build();

		Rating ratings = ratingService.createRatings(rating);
		System.err.println("new rating is " + ratings);

	}



}
