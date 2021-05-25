package net.guides.springboot2.springboot2webappjsp.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;


@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "emp_name")
	private String empName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id",foreignKey=@ForeignKey(name="fk_dept"))
	private Department department;
	
	@Column(name = "salary")
	private float salary; 
	
	@Column(name = "dob")
	private Date dob;

	public Employee() {
	}

	public Employee(Integer empId, String empName, Department department, Date date) {
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.dob = date;
	}

	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + empId + ", name=" + empName + ", department=" + department + ", dob=" + dob + "]";
	}
	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}


}