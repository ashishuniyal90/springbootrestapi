package com.stacksimplify.restapi.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.stacksimplify.restapi.entities.User;
import com.stacksimplify.restapi.exceptions.UserExistsException;
import com.stacksimplify.restapi.exceptions.UserNotFoundException;
import com.stacksimplify.restapi.exceptions.UsernameNotFoundException;
import com.stacksimplify.restapi.services.UserService;

@RestController
@Validated
@RequestMapping("/users")
public class UserController {
	
	// Autowire user service
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	// Request Body Annotation
	// Post Mapping Annotation
	@PostMapping
	public ResponseEntity<Void> createUser(@Valid @RequestBody User user, UriComponentsBuilder builder) {
		try {
			userService.createUser(user);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
		} catch (UserExistsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	// Get Mapping By ID
	// PathVariable Annotation
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			return userService.getUserById(id);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	// Put Mapping Annotation
	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		try {
			return userService.updateUser(id, user);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	// Delete Mapping Annotation
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("/username/{username}")
	public User getUserByUsername(@PathVariable("username") String username) throws UsernameNotFoundException {
		User user = userService.getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Username: '"+ username + "' not found exception");
		}
		return user;
	}

}
