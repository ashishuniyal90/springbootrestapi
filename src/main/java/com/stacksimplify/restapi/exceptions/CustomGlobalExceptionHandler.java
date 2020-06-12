package com.stacksimplify.restapi.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	// MethodArgumentNotValidException Handling
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "Method Argument Not Valid Exception in GEH", ex.getMessage());
		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	// HttpRequestMethodNotSupportedException Handling
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "Request Method Exception in GEH", ex.getMessage());
		return new ResponseEntity<>(customErrorDetails, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public final ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest request) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public final ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException ex, WebRequest request) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	// ConstraintViolationException handling
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintVoilationException(ConstraintViolationException ex, WebRequest request) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
}
