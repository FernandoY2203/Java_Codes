package br.com.yuji.unittest.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import br.com.yuji.data.dto.v1.PersonDTO;
import br.com.yuji.entities.Person;
import br.com.yuji.mapper.MapperConfig;
import br.com.yuji.unittest.mapper.mocks.MockPerson;

class ConverterTest {

	MockPerson inputObject;
	
	MapperConfig mapper = Mappers.getMapper(MapperConfig.class);

	@BeforeEach
	public void setUp() {
		inputObject = new MockPerson();
	}

	@Test
	void parseEntityToDTOTest() {
		PersonDTO output = mapper.toPersonDTO(inputObject.mockEntity());
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("First Name Test0", output.getFirstName());
		assertEquals("Last Name Test0", output.getLastName());
		assertEquals("Addres Test0", output.getAddress());
		assertEquals("Male", output.getGender());
	}

	@Test
	void parseEntityListToDTOListTest() {
		List<PersonDTO> outputList = mapper.toListPersonDTOs(inputObject.mockEntityList());
		PersonDTO outputZero = outputList.get(0);

		assertEquals(Long.valueOf(0L), outputZero.getId());
		assertEquals("First Name Test0", outputZero.getFirstName());
		assertEquals("Last Name Test0", outputZero.getLastName());
		assertEquals("Addres Test0", outputZero.getAddress());
		assertEquals("Male", outputZero.getGender());

		PersonDTO outputSeven = outputList.get(7);

		assertEquals(Long.valueOf(7L), outputSeven.getId());
		assertEquals("First Name Test7", outputSeven.getFirstName());
		assertEquals("Last Name Test7", outputSeven.getLastName());
		assertEquals("Addres Test7", outputSeven.getAddress());
		assertEquals("Female", outputSeven.getGender());

		PersonDTO outputTwelve = outputList.get(12);

		assertEquals(Long.valueOf(12L), outputTwelve.getId());
		assertEquals("First Name Test12", outputTwelve.getFirstName());
		assertEquals("Last Name Test12", outputTwelve.getLastName());
		assertEquals("Addres Test12", outputTwelve.getAddress());
		assertEquals("Male", outputTwelve.getGender());
	}

	@Test
	void parseDTOToEntityTest() {
		Person output = mapper.toPerson(inputObject.mockDTO());
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("First Name Test0", output.getFirstName());
		assertEquals("Last Name Test0", output.getLastName());
		assertEquals("Addres Test0", output.getAddress());
		assertEquals("Male", output.getGender());
	}

	@Test
	void parserDTOListToEntityListTest() {
		List<Person> outputList = mapper.toListPersons(inputObject.mockDTOList());
		Person outputZero = outputList.get(0);

		assertEquals(Long.valueOf(0L), outputZero.getId());
		assertEquals("First Name Test0", outputZero.getFirstName());
		assertEquals("Last Name Test0", outputZero.getLastName());
		assertEquals("Addres Test0", outputZero.getAddress());
		assertEquals("Male", outputZero.getGender());

		Person outputSeven = outputList.get(7);

		assertEquals(Long.valueOf(7L), outputSeven.getId());
		assertEquals("First Name Test7", outputSeven.getFirstName());
		assertEquals("Last Name Test7", outputSeven.getLastName());
		assertEquals("Addres Test7", outputSeven.getAddress());
		assertEquals("Female", outputSeven.getGender());

		Person outputTwelve = outputList.get(12);

		assertEquals(Long.valueOf(12L), outputTwelve.getId());
		assertEquals("First Name Test12", outputTwelve.getFirstName());
		assertEquals("Last Name Test12", outputTwelve.getLastName());
		assertEquals("Addres Test12", outputTwelve.getAddress());
		assertEquals("Male", outputTwelve.getGender());
	}
}
