package com.stacksimplify.restapi.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restapi.dtos.UserDtoV1;
import com.stacksimplify.restapi.dtos.UserDtoV2;
import com.stacksimplify.restapi.dtos.UserMmDto;
import com.stacksimplify.restapi.entities.User;
import com.stacksimplify.restapi.exceptions.UserNotFoundException;
import com.stacksimplify.restapi.services.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/version/users")
@Api(tags = "User Management Services - Versioning", value = "User Controller")
public class UserUriVersioningController {

	// Autowire user service
	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	// Get Mapping By ID
	// PathVariable Annotation
	@GetMapping({ "/v1.0/{id}", "/v1.1/{id}" })
	public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			Optional<User> userOptional = userService.getUserById(id);
			User user = userOptional.get();
			UserDtoV1 userDto1 = modelMapper.map(user, UserDtoV1.class);
			return userDto1;
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	// Get Mapping By ID
	// PathVariable Annotation
	@GetMapping("/v2.0/{id}")
	public UserDtoV2 getUserByIdV2(@PathVariable("id") @Min(1) Long id) {
		try {
			Optional<User> userOptional = userService.getUserById(id);
			User user = userOptional.get();
			UserDtoV2 userDto2 = modelMapper.map(user, UserDtoV2.class);
			return userDto2;
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
