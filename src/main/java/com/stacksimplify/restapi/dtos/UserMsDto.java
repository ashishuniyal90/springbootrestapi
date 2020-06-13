package com.stacksimplify.restapi.dtos;

public class UserMsDto {

	private Long userId;

	private String username;
	
	private String emailaddress;

	public UserMsDto() {
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public UserMsDto(Long userId, String username, String emailaddress) {
		this.userId = userId;
		this.username = username;
		this.emailaddress = emailaddress;
	}

	/**
	 * @return the emailaddress
	 */
	public String getEmailaddress() {
		return emailaddress;
	}

	/**
	 * @param emailaddress the emailaddress to set
	 */
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	
	
	
}
