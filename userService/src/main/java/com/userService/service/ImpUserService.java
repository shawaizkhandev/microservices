package com.userService.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.userService.external.service.HotelService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exception.ResourceNotFoundException;
import com.repositry.UserRepositry;
import com.userService.entity.Hotel;
import com.userService.entity.Rating;
import com.userService.entity.User;
@Service
public class ImpUserService implements UserService{

	@Autowired
	private UserRepositry userRepositry;
	@Autowired
	RestTemplate restTemplate; 
	@Autowired
	HotelService hotelService;
	
	org.slf4j.Logger logger=LoggerFactory.getLogger(ImpUserService.class); 
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String string = UUID.randomUUID().toString();
		user.setUserId(string);
		User save = userRepositry.save(user);
		
		return save;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepositry.findAll();
	}

	@Override 
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		
				User orElseThrow = userRepositry.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id is not found on the server :"+userId));
	//call another service using resttemplate
				Rating[]ratingsArray = restTemplate.getForObject("http://RATING-SERVICE/rating/ratings/users/"+orElseThrow.getUserId(), Rating[].class);
System.err.println("--"+ratingsArray);

	logger.info("--",ratingsArray);
	
	List<Rating> listRating = Arrays.stream(ratingsArray).toList();
	//	
	listRating.stream().map(rating->{
		//http://localhost:8083/rating/users/
//	Hotel hotel =restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
	//declarative aproach fein client
		Hotel hotel = hotelService.getHotel(rating.getHotelId());
		rating.setHotel(hotel);
		return rating;
	}).collect(Collectors.toList());
	
//	orElseThrow.setRatings(forObject);
//	a.info(forObject.toString());
	orElseThrow.setRatings(listRating);
	return orElseThrow;
	}

	@Override
	public String deleteUser(String useriId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
