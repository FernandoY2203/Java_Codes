package com.cursojava.project2_WebServices.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cursojava.project2_WebServices.entities.Category;
import com.cursojava.project2_WebServices.repositories.CategoryRepository;
import com.cursojava.project2_WebServices.services.exceptions.DatabaseException;
import com.cursojava.project2_WebServices.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	//--------------------------------------------------------------------//
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		
		return obj.get();
	}
	
	public Category insert(Category category) {
		return repository.save(category);
	}
	
	public void delete(Long id) {
		try {
			Optional<Category> u = repository.findById(id);
			
			repository.delete(u.get());
		}
		catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Category update(Long id, Category category) {
		try {
			Category entity = repository.getReferenceById(id);
			
			updateData(entity, category);
			
			return repository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Category entity, Category category) {
		entity.setName(category.getName());
	}
}
