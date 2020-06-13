package com.stacksimplify.restapi.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.stacksimplify.restapi.controllers.UserController;

// Entity
@Entity
@Table(name = "user")
@JsonFilter("userFilter")
public class User extends RepresentationModel<User>{
	
	@Id
	@GeneratedValue
	private Long userId;
	
	@NotEmpty(message = "Username is mandatory")
	@Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
	private String username;
	
	@Size(min = 2, message = "Firstname must have atleast 2 characters")
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String firsname;
	
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastname;
	
	@Column(name = "EMAIL", length = 50, nullable = true)
	private String email;
	
	@Column(name = "SSN", length = 50, nullable = false, unique = true)
	private String ssn;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
	
	public User() {
		// No Field constructor
	}
	
	public User(Long userId, String username, String firsname, String lastname, String email, String ssn) {
		this.userId = userId;
		this.username = username;
		this.firsname = firsname;
		this.lastname = lastname;
		this.email = email;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", firsname=" + firsname + ", lastname=" + lastname
				+ ", email=" + email + ", ssn=" + ssn + ", orders=" + orders + "]";
	}


	
	
}
