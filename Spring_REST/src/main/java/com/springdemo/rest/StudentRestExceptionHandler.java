package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*@ControllerAdvice adds global exception handling. */

@ControllerAdvice
public class StudentRestExceptionHandler {

	/* Handling an thrown exception by defining @ExceptionHandler, that returns ResponseEntity.
	 * ResponseEntity is a wrapper for the HTTP response object and provides fine grained control
	 * to specify HTTP status code, headers and Response body.*/ 
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		// Creating custom error using Java POJO
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value()); //404
		errorResponse.setMesssage(exc.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		//error response is converted to JSON by Spring REST that uses Jackson project
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
	// ExceptionHandler for any type of exception
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		// Creating custom error using Java POJO
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value()); //400
		errorResponse.setMesssage(exc.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		//error response is converted to JSON by Spring REST that uses Jackson project
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
}
