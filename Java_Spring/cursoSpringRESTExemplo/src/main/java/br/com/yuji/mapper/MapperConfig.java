package br.com.yuji.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import br.com.yuji.data.dto.v1.PersonDTO;
import br.com.yuji.entities.Person;

@Mapper(componentModel = "spring")
public interface MapperConfig {
	
	PersonDTO toPersonDTO(Person person);
	
	// Teste de Versionamento
	// PersonDTOV2 toPersonDTOV2(Person person);
	
	@InheritInverseConfiguration
	Person toPerson(PersonDTO personDTO);
	
	// @InheritInverseConfiguration
	// Person toPersonV2(PersonDTOV2 personDTO);
	
	List<PersonDTO> toListPersonDTOs(List<Person> personList);
	
	@InheritInverseConfiguration
	List<Person> toListPersons(List<PersonDTO> personDTOList);
}
