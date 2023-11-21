package com.proj3.project3_WebServicesNoSQL.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj3.project3_WebServicesNoSQL.entities.Post;
import com.proj3.project3_WebServicesNoSQL.repository.PostRepository;
import com.proj3.project3_WebServicesNoSQL.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	//------------------------------------------------------------------//
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id));
	}
	
	public List<Post> findByTitle(String title){
		return repository.findByTitleContainingIgnoreCase(title);
	}
	
	public List<Post> searchTitle(String title){
		return repository.searchTitle(title);
	}
	
	public List<Post> searchBetweenDates(String title, LocalDate minDate, LocalDate maxDate){
		maxDate = maxDate.plusDays(1);
		
		return repository.searchBetweenDates(title, minDate, maxDate);
	}
}
