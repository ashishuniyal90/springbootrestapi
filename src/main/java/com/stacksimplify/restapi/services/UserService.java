package com.stacksimplify.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
		return userRepository.findAll();
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
		
	public User updateUser(Long id, User user) throws UserNotFoundException{
		Optional<User> optionalUser = userRepository.findById(id);
		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not found with the id to update");
		}
		user.setId(id);	
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
