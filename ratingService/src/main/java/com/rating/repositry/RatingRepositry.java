package com.rating.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.entity.Ratings;


public interface RatingRepositry  extends JpaRepository<Ratings, String>{
	
//	find by user id
//	Ratings
	List<Ratings> findByUserId(String userId);
	
//	find by hotel id
	List<Ratings> findByHotelId(String hotelId);
}
