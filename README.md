# Spring_Boot-Microservice Exercises
Netflix Eureka example.

Eureka Service Registry Server – This microservice will provide the service registry and discovery server.
Student Microservice – Which will give some functionality based on Student entity. 
It will be a rest based service and most importantly it will be a eureka client service, 
which will talk with eureka service to register itself in the service registry.
School Microservice – Same type as of Student service – only added feature is that it will invoke
Student service with service look up mechanism. We will not use absolute URL of student service to interact with that service.


#Test Eureka Server
Start the application as spring boot application. Open browser and go to http://localhost:8761/, you should see the eureka server home page

#demo url
http://localhost:8098/getStudentDetailsForSchool/abcschool, it will give the Student details for a particular school abcschool.


#Reference
https://howtodoinjava.com/spring-cloud/spring-cloud-service-discovery-netflix-eureka/
#https://dzone.com/articles/microservices-in-spring-eureka

