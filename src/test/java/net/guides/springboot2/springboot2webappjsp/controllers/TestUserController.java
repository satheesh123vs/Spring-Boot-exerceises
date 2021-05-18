package net.guides.springboot2.springboot2webappjsp.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import net.guides.springboot2.springboot2webappjsp.Springboot2WebappJspApplicationTests;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestUserController extends Springboot2WebappJspApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/* Testing post valid scenario -POST */
	@Test
	public void testvalidResponseGet() throws Exception {

		mockMvc.perform(get("/users")).andReturn();
	}

	/*
	 * Testing get in valid scenario, "status": 404, "error": "Not Found", ...
	 * -GET 404 Not Found status code means that the server could not find the
	 * requested URL.
	 */
	@Test
	public void testInvalidRequestResponseGet() throws Exception {

		mockMvc.perform(get("/usersggg")).andExpect(status().isNotFound());
	}

	// We get a 400 BAD REQUEST when the content body is not valid:
	// reference :
	// https://www.wimdeblauwe.com/blog/2020/07/20/error-handling-library-spring-boot/

	// We get a 401 Unauthorized,
	// https://github.com/spring-projects/spring-boot/issues/15061

}
