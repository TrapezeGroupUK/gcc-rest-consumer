# novus-rt-rest-consumer

###Overview
A basic Spring-Boot test client web application which uses the 3scale API to access Novus-RT REST API

###Configure and Build
* The test client requires Java 7 to run & you will need Maven to build it.
* Configuration is Spring annotation driven.
* Config class is Application.java - This is where you will need to add your user_key & baseUrl
* To build run mvn package

###Run
* You will then find novus-rt-consumer-1.0-SNAPSHOT.jar in the target directory
* To run java -jar novus-rt-consumer-1.0-SNAPSHOT.jar
* You can then access the application at localhost:8080 - usage example http://localhost:8080/stopCode/6090238

###Code
* Application.java - This class contains the main method, which launches the SpringBoot application. This class also contains the configuration for the application.
* NovusRTController.java - Spring MVC Controller class - main entry point for the application.
* NovusRTConsumer.java - Spring Component class - uses RestTemplate to call endpoint & return a result.
* NovusRTResult.java - Jackson annotated class mapped to JSON response.
* Event.java - Jackson annotated class mapped to JSON response.
* stop_data.html - thymeleaf template page to render results. http://www.thymeleaf.org
* novus-rt.css - CSS stylesheet

###JSON
An example JSON response can be found at src/test/resources/novus-rt.json
