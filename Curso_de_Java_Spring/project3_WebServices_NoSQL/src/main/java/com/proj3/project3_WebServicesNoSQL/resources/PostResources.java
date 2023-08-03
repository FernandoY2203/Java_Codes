package com.proj3.project3_WebServicesNoSQL.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proj3.project3_WebServicesNoSQL.entities.Post;
import com.proj3.project3_WebServicesNoSQL.resources.util.URL;
import com.proj3.project3_WebServicesNoSQL.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

	@Autowired
	private PostService service;

	// ------------------------------------------------------------------//

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post p = service.findById(id);
		
		return ResponseEntity.ok().body(p);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String title){
		title = URL.decodeParam(title);
		List<Post> posts = service.findByTitle(title); 
		
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value = "/searchtitle")
	public ResponseEntity<List<Post>> searchTitle(@RequestParam(value = "text", defaultValue = "") String title){
		title = URL.decodeParam(title);
		List<Post> posts = service.searchTitle(title); 
		
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value = "/searchbetweendates")
	public ResponseEntity<List<Post>> searchBetweenDates(@RequestParam(value = "text", defaultValue = "") String text, @RequestParam(value = "minDate", defaultValue = "") String minDate, @RequestParam(value = "maxDate", defaultValue = "") String maxDate){
		text = URL.decodeParam(text);
		LocalDate min = URL.convertDate(minDate, LocalDate.ofEpochDay(0L));
		LocalDate max = URL.convertDate(maxDate, LocalDate.now());
		
		List<Post> posts = service.searchBetweenDates(text, min, max); 
		
		return ResponseEntity.ok().body(posts);
	}
}
