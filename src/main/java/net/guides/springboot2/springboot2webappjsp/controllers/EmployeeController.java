package net.guides.springboot2.springboot2webappjsp.controllers;

import java.util.List;

import net.guides.springboot2.springboot2webappjsp.domain.Employee;
import net.guides.springboot2.springboot2webappjsp.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView get(Model model) {
		List<Employee> employeeList = employeeRepository.findAll();
		return new ModelAndView("employeesList", "empList", employeeList);
	}
	
	@RequestMapping(value = "/openEmployeeView", method = RequestMethod.GET)
	public ModelAndView openEmployeeAddView() {
		return new ModelAndView("employeesAdd", "employee", new Employee());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("employee") Employee emp) {
//		employeeRepository.save(emp);
		return "redirect:/list";
	}
}