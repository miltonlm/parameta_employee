package com.parameta.employee;

import com.parameta.employee.rest.employee.DTOEmployee;
import com.parameta.employee.soap.client.EmployeeSOAPClient;
import com.parameta.employee.soap.generated.CreateEmployeeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Testing for the application.
 * */
@SpringBootTest
class EmployeeApplicationTests {

	/**
	 * EmployeeSOAPClient client injection.
	 * */
	@Autowired
	EmployeeSOAPClient client;

	/**
	 * RestTemplate restTemplate injection.
	 * */
	@Autowired
	RestTemplate restTemplate;

	/**
	 * Will test the SOAP client and endpoint.
	 * */
	@Test
	public void checkEmployeeCreationSOAP() {
		DTOEmployee dtoEmployee = new DTOEmployee();
		dtoEmployee.setName("David");
		dtoEmployee.setLastName("Lopez");
		dtoEmployee.setIdentificationType("CC");
		dtoEmployee.setIdentification("125125125");
		dtoEmployee.setBirthDate(java.sql.Date.valueOf(LocalDate.of(1994, 2, 2)));
		dtoEmployee.setEmploymentDate(java.sql.Date.valueOf(LocalDate.of(2019, 5, 2)));
		dtoEmployee.setSalary(5000D);
		dtoEmployee.setPosition("Developer");

		CreateEmployeeResponse response = client.createEmployee(dtoEmployee);

		assertEquals("125125125", response.getEmployee().getIdentification());
		assertEquals(5000D, response.getEmployee().getSalary());
	}

	/**
	 * Will the the REST endpoint.
	 * */
	@Test
	public void checkEmployeeCreationREST() {
		Map<String, Object> values = new HashMap<>();

		values.put("name", "Cristian");
		values.put("lastName", "Lopez");
		values.put("identificationType", "CC");
		values.put("identification", "61126");
		values.put("birthDate", "1996-05-01");
		values.put("employmentDate", "2015-03-03");
		values.put("salary", 80000D);
		values.put("position", "Designer");

		StringBuilder stringBuilder = new StringBuilder("http://localhost:8090/employee?");

		stringBuilder.append("name={name}")
				.append("&lastName={lastName}")
				.append("&identificationType={identificationType}")
				.append("&identification={identification}")
				.append("&birthDate={birthDate}")
				.append("&employmentDate={employmentDate}")
				.append("&salary={salary}")
				.append("&position={position}");

		DTOEmployee createdDTOEmployee = restTemplate.getForObject(stringBuilder.toString(), DTOEmployee.class, values);

		assertEquals("61126", createdDTOEmployee.getIdentification());
		assertEquals(80000D, createdDTOEmployee.getSalary());
	}

}
