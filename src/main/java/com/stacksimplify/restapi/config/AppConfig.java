package com.stacksimplify.restapi.config;

import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stacksimplify.restapi.mappers.UserMapper;

@Configuration
public class AppConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
