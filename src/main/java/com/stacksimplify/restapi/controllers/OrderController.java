package com.stacksimplify.restapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restapi.entities.Order;
import com.stacksimplify.restapi.entities.User;
import com.stacksimplify.restapi.exceptions.OrderNotFoundException;
import com.stacksimplify.restapi.exceptions.UserNotFoundException;
import com.stacksimplify.restapi.repositories.UserRepository;
import com.stacksimplify.restapi.services.OrderService;

@RestController()
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	@GetMapping(params = "id")
	public List<Order> getOrderByUserId(@RequestParam Long id) throws UserNotFoundException{
		return orderService.getOrdersByUserId(id);
	}
	
	@PostMapping("/create/{userid}")
	public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userid);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not found while creating user");
		}
		order.setUser(userOptional.get());
		return orderService.createOrder(order);
	}
	
	@GetMapping("{id}")
	public Order getOrderById(@PathVariable Long id) throws OrderNotFoundException{
		return orderService.getOrderById(id);
	}
}
