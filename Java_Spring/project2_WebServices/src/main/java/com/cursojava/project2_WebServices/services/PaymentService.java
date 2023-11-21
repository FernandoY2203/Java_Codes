package com.cursojava.project2_WebServices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.project2_WebServices.entities.Payment;
import com.cursojava.project2_WebServices.repositories.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;
	
	//--------------------------------------------------------------------//
	
	public List<Payment> findAll(){
		return repository.findAll();
	}
	
	public Payment findById(Long id) {
		Optional<Payment> obj = repository.findById(id);
		
		return obj.get();
	}
}
