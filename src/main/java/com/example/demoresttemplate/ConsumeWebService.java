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
public class ConsumeWebService {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(method = RequestMethod.GET, value = "/employeelist")
	public String getEmployeeById() {

		final String uri = "http://localhost:8080/employees/105";
		RestTemplate restTemplate = new RestTemplate();

		// Use HttpHeaders to set the Request Headers.
		HttpHeaders headers = new HttpHeaders();
		/*
		 * You can receive the response in JSON or XML by setting the Accept
		 * header to application/json or application/xml.
		 */
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		// Use HttpEntity to wrap the request object.
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// Provide the URL, HttpMethod, and Return type for Exchange() method.
		return restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody();
	}

	/*
	 * Based on the "Accept" header defined in the client's browser the response
	 * (either Json or Xml) can be dynamically selected by the Restful service
	 * at run time and sent back to the client.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/employees/{id}", produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> postEmployeeById(@PathVariable("id") Integer id) {
		Employee employee = new Employee(id, "Lokesh Gupta", "howtodoinjava@gmail.com");

		// return response :
		// {"id":106,"name":"Lokesh Gupta","email":"howtodoinjava@gmail.com"}

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}