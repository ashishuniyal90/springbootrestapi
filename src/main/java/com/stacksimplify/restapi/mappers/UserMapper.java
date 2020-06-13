package com.stacksimplify.restapi.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.stacksimplify.restapi.dtos.UserMsDto;
import com.stacksimplify.restapi.entities.User;
import com.stacksimplify.restapi.services.UserService;

@Mapper(componentModel = "spring", uses = UserService.class)	
public interface UserMapper {
	
	// User to UserMsDto
	@Mapping(source = "email", target = "emailaddress")
	UserMsDto userToUserMsDto(User user);
	
	// List<User> to List<UserMsDto>
	List<UserMsDto> userToUserMsDto(List<User> users);
}
