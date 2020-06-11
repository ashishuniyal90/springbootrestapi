package com.stacksimplify.restapi.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	// @RequestMapping( method = RequestMethod.GET, path = "/helloworld")
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	
	
	@GetMapping("/userdetails")
	public UserDetails getUserDetailsBean() {
		return new UserDetails("ashish", "uniyal", "mumbai");
	}
	
	
}
