package com.example.demoresttemplate;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/employee")
public class ConsumeEmployeeWebService {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String getEmployeeList() {

		final String uri = "http://localhost:8080/employee/105";
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		// Use HttpEntity to wrap the request object.
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// Provide the URL, HttpMethod, and Return type for Exchange() method.
		return restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		Employee employee = new Employee(id, "Lokesh Gupta", "howtodoinjava@gmail.com");

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}