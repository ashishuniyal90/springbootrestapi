package com.stacksimplify.restapi.exceptions;

import java.util.Date;

// Custom Error Class 
public class CustomErrorDetails {
	
	private Date timestamp;
	private String message;
	private String errorDetails;
	
	public CustomErrorDetails(Date timestamp, String message, String errorDetails) {
		this.timestamp = timestamp;
		this.message = message;
		this.errorDetails = errorDetails;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the errorDetails
	 */
	public String getErrorDetails() {
		return errorDetails;
	}

	/**
	 * @param errorDetails the errorDetails to set
	 */
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	
}
