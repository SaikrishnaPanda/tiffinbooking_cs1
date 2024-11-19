package com.tiffinebooking.tiffinmodule.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(TiffinCanNotFoundException.class)
	public ResponseEntity<String> handleAdminAuthenticationFailureException(Exception e){

         ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
         return responseEntity;
       
    }
}

