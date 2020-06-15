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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.stacksimplify.restapi.controllers.UserController;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

// Entity
@Entity
@Table(name = "usere")
// @JsonIgnoreProperties({"ssn","email"}) -- Used with static filtering
// @JsonFilter("userFilter") -- used for mapping jackson value filtering
@ApiModel(description = "User Model for saving user related data")
public class User {
	
	@ApiModelProperty(notes = "Auto Generated Id", required = true)
	@Id
	@GeneratedValue
	@JsonView(Views.Public.class)
	private Long userId;
	
	@ApiModelProperty(notes = "Username for the user", required = true)
	@NotEmpty(message = "Username is mandatory..")
	@Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
	@JsonView(Views.Public.class)
	private String username;
	
	@ApiModelProperty(notes = "Firstname for the user", required = true)
	@Size(min = 2, max = 100, message = "Firstname must have atleast 2 characters")
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	@JsonView(Views.Public.class)
	private String firsname;
	
	@ApiModelProperty(notes = "lastname for the user", required = true)
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	@JsonView(Views.Public.class)
	private String lastname;
	
	@ApiModelProperty(notes = "Email for the user", required = false)
	@Column(name = "EMAIL", length = 50, nullable = true)
	@JsonView(Views.Public.class)
	private String email;
	
	// @JsonIgnore -- Used with static mapping
	@ApiModelProperty(notes = "ssn for the user", required = true)
	@Column(name = "SSN", length = 50, nullable = false, unique = true)
	@JsonView(Views.Internal.class)
	private String ssn;
	
	@OneToMany(mappedBy = "user")
	@JsonView(Views.Internal.class)
	private List<Order> orders;
	
	@ApiModelProperty(notes = "address for the user", required = false)
	@Column(name = "ADDRESS")
	private String address;
	
	public User() {
		// No Field constructor
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public User(Long userId, @NotEmpty(message = "Username is mandatory") String username,
			@Size(min = 2, message = "Firstname must have atleast 2 characters") String firsname, String lastname,
			String email, String ssn, List<Order> orders, String address) {
		this.userId = userId;
		this.username = username;
		this.firsname = firsname;
		this.lastname = lastname;
		this.email = email;
		this.ssn = ssn;
		this.orders = orders;
		this.address = address;
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
