package com.proj3.project3_WebServicesNoSQL.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.proj3.project3_WebServicesNoSQL.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String title);
	
	@Query("{'title': {$regex: ?0, $options: 'i'}}")
	List<Post> searchTitle(String title);
	
	@Query("{$and: [{date: {$gte: ?1}}, {date: {$lte: ?2}}, {$or: [{'title': {$regex: ?0, $options: 'i'}}, {'body': {$regex: ?0, $options: 'i'}}, {'comments.text': {$regex: ?0, $options: 'i'}}]}]}")
	List<Post> searchBetweenDates(String text, LocalDate minDate, LocalDate maxDate);
}
