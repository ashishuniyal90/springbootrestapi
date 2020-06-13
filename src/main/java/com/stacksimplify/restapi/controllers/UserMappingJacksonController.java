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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.stacksimplify.restapi.entities.User;
import com.stacksimplify.restapi.exceptions.UserNotFoundException;
import com.stacksimplify.restapi.services.UserService;

@RestController
@RequestMapping("/filter/users")
@Validated
public class UserMappingJacksonController {

	// Autowire user service
	@Autowired
	private UserService userService;

	// Get Mapping By ID
	// PathVariable Annotation
	@GetMapping("/{id}")
	public MappingJacksonValue getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			Optional<User> userOptional = userService.getUserById(id);
			User user = userOptional.get();

			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);
			Set<String> fields = new HashSet<String>();
			fields.add("userId");
			fields.add("username");
			fields.add("email");
			FilterProvider filters = new SimpleFilterProvider().addFilter("userFilter",
					SimpleBeanPropertyFilter.filterOutAllExcept(fields));
			mappingJacksonValue.setFilters(filters);
			return mappingJacksonValue;
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	// Get Mapping By ID
	// PathVariable Annotation
	@GetMapping("/params/{id}")
	public MappingJacksonValue getUserByIdWithParams(@PathVariable("id") @Min(1) Long id,
			@RequestParam Set<String> fields) {
		try {
			Optional<User> userOptional = userService.getUserById(id);
			User user = userOptional.get();

			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);
			FilterProvider filters = new SimpleFilterProvider().addFilter("userFilter",
					SimpleBeanPropertyFilter.filterOutAllExcept(fields));
			mappingJacksonValue.setFilters(filters);
			return mappingJacksonValue;
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
