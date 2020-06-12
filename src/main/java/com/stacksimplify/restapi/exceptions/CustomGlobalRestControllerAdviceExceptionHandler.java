package com.stacksimplify.restapi.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class CustomGlobalRestControllerAdviceExceptionHandler {
	
	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomErrorDetails userNameNotFound(UsernameNotFoundException exception) {
		return new CustomErrorDetails(new Date(), exception.getMessage(), "From Restcontroller advice");
	}
	
}
