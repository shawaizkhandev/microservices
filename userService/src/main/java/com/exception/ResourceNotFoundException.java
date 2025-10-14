package com.exception;

public class ResourceNotFoundException extends RuntimeException{

	
	public ResourceNotFoundException() {
		super("Resourece not found on server");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
