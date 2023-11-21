package com.cursojava.project2_WebServices.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cursojava.project2_WebServices.entities.Product;
import com.cursojava.project2_WebServices.repositories.ProductRepository;
import com.cursojava.project2_WebServices.services.exceptions.DatabaseException;
import com.cursojava.project2_WebServices.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	//--------------------------------------------------------------------//
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		
		return obj.get();
	}
	
	public Product insert(Product product) {
		return repository.save(product);
	}
	
	public void delete(Long id) {
		try {
			Optional<Product> u = repository.findById(id);
			
			repository.delete(u.get());
		}
		catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Product update(Long id, Product product) {
		try {
			Product entity = repository.getReferenceById(id);
			
			updateData(entity, product);
			
			return repository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product entity, Product product) {
		entity.setName(product.getName());
		entity.setDescription(product.getDescription());
		entity.setPrice(product.getPrice());
		entity.setImgUrl(product.getImgUrl());
	}
}
