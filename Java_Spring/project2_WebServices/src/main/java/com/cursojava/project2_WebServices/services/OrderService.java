package com.cursojava.project2_WebServices.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cursojava.project2_WebServices.entities.Order;
import com.cursojava.project2_WebServices.repositories.OrderRepository;
import com.cursojava.project2_WebServices.services.exceptions.DatabaseException;
import com.cursojava.project2_WebServices.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	//--------------------------------------------------------------------//
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		
		return obj.get();
	}
	
	public Order insert(Order order) {
		return repository.save(order);
	}
	
	public void delete(Long id) {
		try {
			Optional<Order> o = repository.findById(id);
			
			repository.delete(o.get());
		}
		catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Order update(Long id, Order order) {
		try {
			Order entity = repository.getReferenceById(id);
			
			updateData(entity, order);
			
			return repository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Order entity, Order order) {
		entity.setMoment(order.getMoment());
		entity.setOrderStatus(order.getOrderStatus());
	}
}
