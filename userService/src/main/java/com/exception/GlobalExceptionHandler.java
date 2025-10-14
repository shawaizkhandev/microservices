package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.payload.ApiResponse;


@RestControllerAdvice 
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse>	handlerResourseNotFound(ResourceNotFoundException exception){
		String message=exception.getMessage();
		ApiResponse build = ApiResponse.builder().message(message).sucess(true).status(HttpStatus.NOT_FOUND).build();
			return new ResponseEntity<>(build,HttpStatus.NOT_FOUND);
	}
  }
