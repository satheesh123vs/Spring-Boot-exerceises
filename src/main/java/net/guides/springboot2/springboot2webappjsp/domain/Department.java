package net.guides.springboot2.springboot2webappjsp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deptId;

	@Column(name = "dept_name")
	private String deptName;

	@Column(name = "emp_name")
	private String empName;

	public Department() {
	}

	public Department(Integer deptId, String deptName, String empName) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.empName = empName;
	}

	public String getEmpName() {
		return empName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
