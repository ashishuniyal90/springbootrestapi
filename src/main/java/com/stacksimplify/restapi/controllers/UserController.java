package com.stacksimplify.restapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restapi.entities.User;
import com.stacksimplify.restapi.services.UserService;

@RestController
public class UserController {
	
	// Autowire user service
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	// Request Body Annotation
	// Post Mapping Annotation
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	// Get Mapping By ID
	// PathVariable Annotation
	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}
	
	// Put Mapping Annotation
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	// Delete Mapping Annotation
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("/user/username/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return userService.getUserByUserName(username);
	}

}
