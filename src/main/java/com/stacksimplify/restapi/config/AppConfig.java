package com.stacksimplify.restapi.config;

import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stacksimplify.restapi.mappers.UserMapper;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AppConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.stacksimplify.restapi.controllers"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("SpringBoot User Management Rest API")
				.description("Page shows all API's related to user & order with other concepts").version("2.0")
				.contact(new Contact("Ashish Uniyal", "https://cryptic-reef-02597.herokuapp.com/users", "auniyal@deloitte.com")).build();
	}
}
