# Spring_Boot_security_Example

implement basic authentication for RESTful web services using Spring Boot and Spring Security.
We will need to create a java file with spring security configurations in it.

run the application
-------------------
hit:

DROP TABLE hibernate_sequence;
DROP TABLE user_role;
DROP TABLE ROLE;
DROP TABLE users;

SELECT * FROM users;
SELECT * FROM ROLE;
SELECT * FROM user_role;
 
CREATE TABLE users(
user_id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(50) UNIQUE NOT NULL,
PASSWORD VARCHAR(50) NOT NULL,
disabled BOOLEAN DEFAULT FALSE,
account_expired BOOLEAN DEFAULT FALSE,
account_locked BOOLEAN DEFAULT FALSE,
credentials_expired BOOLEAN DEFAULT FALSE
);

TRUNCATE users;

INSERT INTO users (user_id,username,PASSWORD,disabled,account_expired,account_locked,credentials_expired) VALUES(1,'admin','password',FALSE,FALSE,FALSE,FALSE);
INSERT INTO users (user_id,username,PASSWORD,disabled,account_expired,account_locked,credentials_expired) VALUES(2,'user','password',FALSE,FALSE,FALSE,FALSE);
 
 
INSERT INTO ROLE (role_id,role_name) VALUES(1,'ADMIN');
INSERT INTO ROLE (role_id,role_name) VALUES(2,'USER');