package com.hotelService.exception;

import java.util.function.Supplier;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String string) {
		super(string);
	}

	public ResourceNotFoundException() {
		super("Resource not found ");
	}
	

}
