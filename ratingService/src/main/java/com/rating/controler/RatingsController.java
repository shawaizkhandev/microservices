package com.rating.controler;

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

import com.rating.entity.Ratings;
import com.rating.repositry.RatingRepositry;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingsController {

	@Autowired
	RatingService ratingService;  
	
	// create ratings
	@PostMapping
	public ResponseEntity<Ratings> createRating(@RequestBody Ratings rating){
		
		Ratings createRating = ratingService.createRating(rating);	
		return ResponseEntity.status(HttpStatus.CREATED).body(createRating);
		
	}
	// get all rating
	@GetMapping
	public ResponseEntity<List<Ratings>> getAll(){
		
		List<Ratings> allRatings = ratingService.getAllRatings();	
		return ResponseEntity.ok(allRatings);
		
	}
	// get rasting by user id
	@GetMapping("/users/{userId}")
public ResponseEntity<List<Ratings>> getbyUserId(@PathVariable String userId){
		
		List<Ratings> allRatings = ratingService.getbyId(userId);	
		return ResponseEntity.ok(allRatings);
		
	}
// get ratings by hotel id
@GetMapping("/hotels/{hotelId}")
public ResponseEntity<List<Ratings>> getByHotelId(@PathVariable String hotelId){
	
	List<Ratings> allRatings = ratingService.getbyHotelId(hotelId);	
	return ResponseEntity.ok(allRatings);
	
}
}
