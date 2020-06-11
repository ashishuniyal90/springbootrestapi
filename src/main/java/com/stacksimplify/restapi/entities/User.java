package com.stacksimplify.restapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// Entity
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
	private String username;
	
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String firsname;
	
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastname;
	
	@Column(name = "EMAIL", length = 50, nullable = true)
	private String email;
	
	@Column(name = "SSN", length = 50, nullable = false, unique = true)
	private String ssn;
	
	public User() {
		// No Field constructor
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public User(Long id, String username, String firsname, String lastname, String email, String ssn) {
		this.id = id;
		this.username = username;
		this.firsname = firsname;
		this.lastname = lastname;
		this.email = email;
		this.ssn = ssn;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firsname=" + firsname + ", lastname=" + lastname
				+ ", email=" + email + ", ssn=" + ssn + "]";
	}
	
}
