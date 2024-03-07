package br.com.yuji.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yuji.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
}
