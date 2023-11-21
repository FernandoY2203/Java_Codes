package com.cursojava.project2_WebServices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.project2_WebServices.entities.OrderItem;
import com.cursojava.project2_WebServices.repositories.OrderItemRepository;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository repository;
	
	//--------------------------------------------------------------------//
	
	public List<OrderItem> findAll(){
		return repository.findAll();
	}
}
