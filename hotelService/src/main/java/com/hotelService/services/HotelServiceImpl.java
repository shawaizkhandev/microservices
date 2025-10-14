package com.hotelService.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelService.entitiy.Hotel;
import com.hotelService.exception.ResourceNotFoundException;
import com.hotelService.repository.HotelRepository;
@Service
public class HotelServiceImpl implements HotelService {
@Autowired
	private HotelRepository hotelRepository; 
	
	@Override
	public Hotel create(Hotel hotel) {
		String string = UUID.randomUUID().toString();
		hotel.setId(string);
		
		Hotel save = hotelRepository.save(hotel);
	return save;
	}

	@Override
	public List<Hotel> getAll() {
		List<Hotel> findAll = hotelRepository.findAll();
	return findAll;
	}

	@Override
	public Hotel getdata(String id) {
		Hotel findById = hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("hotel with given id not found !!"));
		return findById;
	}

}
