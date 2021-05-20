package net.guides.springboot2.springboot2webappjsp.repositories;

import net.guides.springboot2.springboot2webappjsp.domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
