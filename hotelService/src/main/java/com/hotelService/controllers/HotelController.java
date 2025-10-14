package com.hotelService.controllers;

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

import com.hotelService.entitiy.Hotel;
import com.hotelService.services.HotelService;
import com.hotelService.services.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
//	create
	@PostMapping
	ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
		
	}
//	get single 
	@GetMapping("/{hotelId}")
	ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getdata(hotelId));
		
	}
	
//	get all
	@GetMapping()
	ResponseEntity<List<Hotel>> getAll(){
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
		
	}

}
