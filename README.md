# springboot2-webapp-jsp : many-to-one mapping example
Spring mvc web application using Spring Boot 2 JSP JPA/Hibernate 5 MySQL example

Explaination of this source code available on below article 

http://www.javaguides.net/2018/09/spring-mvc-using-spring-boot2-jsp-jpa-hibernate5-mysql-example.html

#url : 
http://localhost:8080/springboot2webapp/list

#DDL
CREATE TABLE employee
(
    emp_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(255),
    salary decimal(8,2) DEFAULT NULL,
    dob DATE,
    dept_id INT,
    constraint fk_dept foreign key(dept_id) references department(dept_id)
   );
CREATE TABLE department
(
    dept_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    dept_name VARCHAR(255),
    emp_name VARCHAR(255)
);

#CONSTRAINT
ALTER TABLE employee
     ADD CONSTRAINT fk_dept
     FOREIGN KEY (dept_id)
     REFERENCES department(dept_id);
     
ALTER TABLE employee
DROP foreign key fk_dept;

#DML
SELECT * 
FROM   information_schema.table_constraints
WHERE  table_schema = schema()
AND    table_name = 'employee';

truncate table department;
INSERT INTO `mysql`.`employee` (`emp_id`, `emp_name`,`salary`,`dob`,`dept_id`) VALUES ('101','Anoop','101250','1988-08-24', '1');
INSERT INTO `mysql`.`employee` (`emp_id`, `emp_name`,`salary`,`dob`,`dept_id`) VALUES ('202','Kiran','30122.50','1985-08-24', '2');

INSERT INTO `mysql`.`department` (`dept_id`, `dept_name`,`emp_name`) VALUES ('1', 'electricity','Anoop');
INSERT INTO `mysql`.`department` (`dept_id`, `dept_name`,`emp_name`) VALUES ('2', 'water','kiran');
