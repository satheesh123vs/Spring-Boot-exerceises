# springboot2-webapp-jsp
Spring mvc web application using Spring Boot 2 JSP JPA/Hibernate 5 MySQL example

Explaination of this source code available on below article 

http://www.javaguides.net/2018/09/spring-mvc-using-spring-boot2-jsp-jpa-hibernate5-mysql-example.html

#url : 
http://localhost:8080/springboot2webapp/users

#DDL
CREATE TABLE usr
(
id int NOT NULL PRIMARY KEY,
name varchar(255) NOT NULL,
)

#DML
INSERT INTO `mysql`.`usr` (`id`, `name`) VALUES ('1', 'SRK');
INSERT INTO `mysql`.`usr` (`id`, `name`) VALUES ('2', 'MLal');

