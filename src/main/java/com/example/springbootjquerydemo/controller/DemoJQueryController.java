package com.example.springbootjquerydemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoJQueryController {

	@RequestMapping("/index")
	public ModelAndView loginMessage() {

		List<Employee> empList = new ArrayList<Employee>();
		Employee emp1 = new Employee(1, "Lokesh Gupta", "howtodoinjava@gmail.com");
		Employee emp2 = new Employee(2, "Athul Malhotra", "malhotraAthul@gmail.com");

		empList.add(emp1);
		empList.add(emp2);
		
		return new ModelAndView("index", "empList", empList);
	}

}
