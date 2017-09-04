## MCQ REST service 
Developed with Spring Boot 1.5.6.RELEASE, [Spring 4.3.x, Hibernate 5.0.x], MariaDB

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