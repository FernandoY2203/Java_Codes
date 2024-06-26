package br.com.yuji.bootcampPadroesProjetoExemplo.repositories;

// Strategy sendo utilizado pelo JpaRepository

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.yuji.bootcampPadroesProjetoExemplo.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
