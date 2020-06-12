package com.stacksimplify.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimplify.restapi.entities.Order;
import com.stacksimplify.restapi.entities.User;
import com.stacksimplify.restapi.exceptions.OrderNotFoundException;
import com.stacksimplify.restapi.exceptions.UserNotFoundException;
import com.stacksimplify.restapi.repositories.OrderRepository;
import com.stacksimplify.restapi.repositories.UserRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	public List<Order> getOrdersByUserId(Long id) throws UserNotFoundException{
		Optional<User> useOptional = userRepository.findById(id);
		if (!useOptional.isPresent()) {
			throw new UserNotFoundException("User not found in there");
		}
		return orderRepository.getOrderByUserUserId(id);
	}
	
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public Order getOrderById(Long id) throws OrderNotFoundException {
		Optional<Order> orderOptional = orderRepository.findById(id);
		if (!orderOptional.isPresent()) {
			throw new OrderNotFoundException("Order not found exception");
		}
		return orderOptional.get();
	}
}
