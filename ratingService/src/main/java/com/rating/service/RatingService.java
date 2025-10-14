package com.rating.service;

import java.util.List;

import com.rating.entity.Ratings;

public interface RatingService {

	
//	create rating
	Ratings createRating(Ratings rating);
	
//	get all ratings 
	
	List<Ratings> getAllRatings();
//	get all rating by user id
	
	List<Ratings> getbyId(String id);

	//	GET all by hotel
	List<Ratings> getbyHotelId(String hotelId);

}
