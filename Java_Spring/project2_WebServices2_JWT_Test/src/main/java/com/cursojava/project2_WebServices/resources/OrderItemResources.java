package com.cursojava.project2_WebServices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.project2_WebServices.entities.OrderItem;
import com.cursojava.project2_WebServices.services.OrderItemService;

@RestController
@RequestMapping(value = "/orderitems")
public class OrderItemResources {
	
	@Autowired
	private OrderItemService service;
	
	//--------------------------------------------------------------------//
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> findAll(){
		List<OrderItem> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
}
