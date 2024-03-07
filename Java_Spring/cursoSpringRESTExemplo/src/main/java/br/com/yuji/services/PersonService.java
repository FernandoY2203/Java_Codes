package br.com.yuji.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yuji.controller.exceptions.ResourceNotFoundException;
import br.com.yuji.data.dto.v1.PersonDTO;
import br.com.yuji.entities.Person;
import br.com.yuji.mapper.MapperConfig;
import br.com.yuji.repositories.PersonRepository;

@Service
public class PersonService {
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private MapperConfig mapper;
	
	
	public List<PersonDTO> findAll() {
		logger.info("Finding all people");
		
		return mapper.toListPersonDTOs(repository.findAll());
	}
	
	public PersonDTO findById(Long id) {
		logger.info("Finding person");
		
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
		
		return mapper.toPersonDTO(entity);
	}
	
	public PersonDTO create(PersonDTO personDTO) {
		logger.info("Creating person");
		
		Person entity = mapper.toPerson(personDTO);
		Person resp = repository.save(entity);
		
		return mapper.toPersonDTO(resp);
	} 
	
	// Teste de Versionamento
//	public PersonDTOV2 createV2(PersonDTOV2 personDTO) {
//		logger.info("Creating person");
//		
//		Person entity = mapper.toPersonV2(personDTO);
//		Person resp = repository.save(entity);
//		
//		return mapper.toPersonDTOV2(resp);
//	} 
	
	public PersonDTO update(PersonDTO personDTO) {
		logger.info("updating person");
		
		Person entity = repository.findById(personDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
		
		updateData(entity, personDTO);
		
		Person resp = repository.save(entity);
		
		return mapper.toPersonDTO(resp);
	}
	
	public void delete(Long id) {
		logger.info("Deleting person");
		
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
		
		repository.delete(entity);
	}
	
	
	private void updateData(Person entity, PersonDTO personDTO) {
		entity.setFirstName(personDTO.getFirstName());
		entity.setLastName(personDTO.getLastName());
		entity.setAddress(personDTO.getAddress());
		entity.setGender(personDTO.getGender());
	}
}
