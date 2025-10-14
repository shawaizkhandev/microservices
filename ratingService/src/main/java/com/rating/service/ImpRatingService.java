package com.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entity.Ratings;
import com.rating.repositry.RatingRepositry;
@Service
public class ImpRatingService implements RatingService{

	@Autowired
	private RatingRepositry ratingRepositry;
	@Override
	public Ratings createRating(Ratings rating) {
	
		String string = UUID.randomUUID().toString();
		rating.setRatingId(string);
		Ratings save = ratingRepositry.save(rating);
		
		return save;
	}

	@Override
	public List<Ratings> getAllRatings() {
		List<Ratings> findAll = ratingRepositry.findAll();
		
	return findAll;
	}

	@Override
	public List<Ratings> getbyId(String id) {
		List<Ratings> findByUserId = ratingRepositry.findByUserId(id);

	return findByUserId;
	}

	@Override
	public List<Ratings> getbyHotelId(String hotelId) {
		List<Ratings> findByUserId = ratingRepositry.findByHotelId(hotelId);
		
	return findByUserId;
	}

}
