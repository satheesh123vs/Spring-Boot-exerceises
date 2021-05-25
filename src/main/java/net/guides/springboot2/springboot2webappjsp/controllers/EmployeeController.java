package net.guides.springboot2.springboot2webappjsp.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import net.guides.springboot2.springboot2webappjsp.domain.Department;
import net.guides.springboot2.springboot2webappjsp.domain.Employee;
import net.guides.springboot2.springboot2webappjsp.repositories.DepartmentRepository;
import net.guides.springboot2.springboot2webappjsp.repositories.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;

	final static Logger logger = LoggerFactory.getLogger("EmployeeController");

	List<Employee> employeeList;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView get(Model model) {
		List<Employee> employeeList = employeeRepository.findAll();
		employeeList.forEach(System.out::println);
		return new ModelAndView("employeesList", "empList", employeeList);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ModelAndView getEmployeeById(@PathVariable Integer id, Model model) {

		employeeList = new ArrayList<Employee>();
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {
			logger.info("employee record found with id: " + optional.get());
			employeeList.add(optional.get());
		} else {
			throw new RecordNotFoundException("Record not found");
		}
		return new ModelAndView("employeesList", "empList", employeeList);
	}

	@RequestMapping(value = "/openEmployeeView", method = RequestMethod.GET)
	public ModelAndView openEmployeeAddView(Model model) {
		model.addAttribute("emp", new Employee());
		List<Department> departments = departmentRepository.findAll();
		model.addAttribute("deps", departments);
		return new ModelAndView("employeesAdd");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
	public String save(@RequestParam String empName,@RequestParam Department department,@RequestParam float salary,@RequestParam Date dob) {
		
		Department department1 = departmentRepository.getOne(department.getDeptId());
		Employee emp = new Employee();
		emp.setDepartment(department1);
		emp.setEmpName(empName);
		emp.setSalary(salary);
		emp.setDob(dob);
		employeeRepository.save(emp);
		return "redirect:/list";
	}
}