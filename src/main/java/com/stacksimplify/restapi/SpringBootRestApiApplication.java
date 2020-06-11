package com.stacksimplify.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.stacksimplify.restapi.repositories")
@EntityScan("com.stacksimplify.restapi.entities")
@ComponentScan("com.stacksimplify.restapi.controllers")
@ComponentScan("com.stacksimplify.restapi.services")
public class SpringBootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplication.class, args);
	}

}
