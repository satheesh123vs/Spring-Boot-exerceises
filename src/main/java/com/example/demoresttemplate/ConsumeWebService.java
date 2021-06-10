package com.example.demoresttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeWebService {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(method = RequestMethod.GET,value = "/employeelist")
	public ResponseEntity<Employee> getEmployeeById() {
		
		final String uri = "http://localhost:8080/employees/105";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee> response = restTemplate.getForEntity(uri, Employee.class);

		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{id}", produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> postEmployeeById(@PathVariable("id") Integer id) {
		
		Employee employee = new Employee(id, "Lokesh Gupta", "howtodoinjava@gmail.com");
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}