package com.stacksimplify.restapi.dtos;

import java.util.List;


import com.stacksimplify.restapi.entities.Order;

public class UserDtoV1 {
	
	
	private Long userId;
	
	private String username;
	
	private String firsname;
	
	private String lastname;
	
	private String email;
	
	private String ssn;
	
	private List<Order> orders;

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

	/**
	 * @return the firsname
	 */
	public String getFirsname() {
		return firsname;
	}

	/**
	 * @param firsname the firsname to set
	 */
	public void setFirsname(String firsname) {
		this.firsname = firsname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public UserDtoV1() {
	}

	public UserDtoV1(Long userId, String username, String firsname, String lastname, String email, String ssn,
			List<Order> orders) {
		super();
		this.userId = userId;
		this.username = username;
		this.firsname = firsname;
		this.lastname = lastname;
		this.email = email;
		this.ssn = ssn;
		this.orders = orders;
	}
	
	

}
