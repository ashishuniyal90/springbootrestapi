package com.stacksimplify.restapi.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.stacksimplify.restapi.entities.User;
import com.stacksimplify.restapi.entities.Views;
import com.stacksimplify.restapi.exceptions.UserNotFoundException;
import com.stacksimplify.restapi.services.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/filter/view/users")
@Validated
@Api(tags = "User Management Services using JsonView", value = "User Controller")
public class UserJsonViewFilterController {

	// Autowire user service
	@Autowired
	private UserService userService;

	// Get Mapping By ID
	// PathVariable Annotation
	@JsonView(Views.Public.class)
	@GetMapping("/external/{id}")
	public User getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			return userService.getUserById(id).get();
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	// Get Mapping By ID
	// PathVariable Annotation
	@JsonView(Views.Internal.class)
	@GetMapping("/internal/{id}")
	public User getUserByIdInternal(@PathVariable("id") @Min(1) Long id) {
		try {
			return userService.getUserById(id).get();
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
