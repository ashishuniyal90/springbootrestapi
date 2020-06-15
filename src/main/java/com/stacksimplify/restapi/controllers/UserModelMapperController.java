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

import com.stacksimplify.restapi.dtos.UserMmDto;
import com.stacksimplify.restapi.entities.User;
import com.stacksimplify.restapi.exceptions.UserNotFoundException;
import com.stacksimplify.restapi.services.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/modelmapper/users")
@Api(tags = "User Management Services - Model Mappers", value = "User Controller")
public class UserModelMapperController {

	// Autowire user service
	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	// Get Mapping By ID
	// PathVariable Annotation
	@GetMapping("/{id}")
	public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			Optional<User> userOptional = userService.getUserById(id);
			User user = userOptional.get();
			UserMmDto userMmDto = modelMapper.map(user, UserMmDto.class);
			return userMmDto;
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
