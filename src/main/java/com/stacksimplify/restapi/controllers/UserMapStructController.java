package com.stacksimplify.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restapi.dtos.UserMsDto;
import com.stacksimplify.restapi.mappers.UserMapper;
import com.stacksimplify.restapi.repositories.UserRepository;
import com.stacksimplify.restapi.services.UserService;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {
	
	// Autowire user service
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private UserMapper userMapper;
//	
//	@GetMapping
//	public List<UserMsDto> getAllUsers() {
//		return userMapper.userToUserMsDto(userRepository.findAll());
//	}

}
