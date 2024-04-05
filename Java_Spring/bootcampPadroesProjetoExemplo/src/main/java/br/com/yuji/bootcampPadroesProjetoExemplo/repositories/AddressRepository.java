package br.com.yuji.bootcampPadroesProjetoExemplo.repositories;

// Strategy sendo utilizado pelo JpaRepository

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.yuji.bootcampPadroesProjetoExemplo.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String>{
	
}
