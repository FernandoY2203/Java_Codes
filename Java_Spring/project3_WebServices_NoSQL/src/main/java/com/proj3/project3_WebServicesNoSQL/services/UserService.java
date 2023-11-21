package com.proj3.project3_WebServicesNoSQL.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj3.project3_WebServicesNoSQL.dto.UserDTO;
import com.proj3.project3_WebServicesNoSQL.entities.User;
import com.proj3.project3_WebServicesNoSQL.repository.UserRepository;
import com.proj3.project3_WebServicesNoSQL.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	//------------------------------------------------------------------//
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id));
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		
		repository.deleteById(id);
	}
	
	public User update(User user) {
		User entity = findById(user.getId());
		
		updateData(entity, user);
		
		return repository.save(entity);
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
