## MCQ REST service 
Developed with Spring Boot 1.3.5, [Spring 4.2.x, Hibernate 4.3.x] MySQL

### Configurations

Configurations are in `application.properties` file 

#### Prerequisites

- Java 8
- Maven 3

#### From terminal

Go on the project's root folder, then type:
	$ mvn clean package			[creates the jar package in target folder]
	$ java -jar path_to_jar		[runs within embebbeded Tomcat]

		OR

    $ mvn spring-boot:run