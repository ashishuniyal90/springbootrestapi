package com.stacksimplify.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restapi.controllers.OrderController;
import com.stacksimplify.restapi.controllers.UserController;
import com.stacksimplify.restapi.entities.Order;
import com.stacksimplify.restapi.entities.User;
import com.stacksimplify.restapi.exceptions.UserExistsException;
import com.stacksimplify.restapi.exceptions.UserNotFoundException;
import com.stacksimplify.restapi.repositories.UserRepository;

// Serrvice Class
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		List<User> users= userRepository.findAll();
		for (final User user : users) {
			user.add(WebMvcLinkBuilder.linkTo(UserController.class).slash(user.getUserId()).withSelfRel());
			try {
				List<Order> orders = WebMvcLinkBuilder.methodOn(OrderController.class).getOrderByUserId(user.getUserId());
				Link ordersLink = WebMvcLinkBuilder.linkTo(orders).withRel("all-orders");
				user.add(ordersLink);
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		
		return users;
	}
	
	public User createUser(User user) throws UserExistsException {
		// If username already exits in db throw UserExistsException
		User existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser != null) {
			throw new UserExistsException("User already exists");
		}
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		return user;
	}
		
	public User updateUser(Long userId, User user) throws UserNotFoundException{
		Optional<User> optionalUser = userRepository.findById(userId);
		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not found with the id to update");
		}
		user.setUserId(userId);	
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) {	
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found in db");
		}
	}
	
	public User getUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}
}
