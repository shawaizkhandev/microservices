package com.hotelService.services;

import java.util.List;

import com.hotelService.entitiy.Hotel;

public interface HotelService {

	
	//create the data of hotel
	
	Hotel create (Hotel hotel);
	
//	get all data 
	
	List <Hotel> getAll();
	
 //	get single data
	
	Hotel getdata(String id);
}
