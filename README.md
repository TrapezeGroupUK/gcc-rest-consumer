# gcc-rest-consumer

A basic Spring-Boot test client web application which uses the 3scale API to access Novus-RT GCC REST API

The test client requires Java 7 to run & you will need Maven to build it.

Configuration is Spring annotation driven.

Config class is Application.java - This is where you will need to add your user_key & baseUrl

To build run mvn package

You will then find gcc-consumer-1.0-SNAPSHOT.jar in the target directory

To run java -jar gcc-consumer-1.0-SNAPSHOT.jar

You can then access the application at localhost:8080 - usage example http://localhost:8080/stopCode/6090238

Code:
Application.java - This class contains the main method, which launches the SpringBoot application. This class alos contains the configuration for the application.
GCCController.java - Spring MVC Controller class - main entry point for the application.
GCCConsumer.java - Spring Component class - uses RestTemplate to call endpoint & return a result.
GCCResult.java - Jackson annotated class mapped to JSON response.
Event.java - Jackson annotated class mapped to JSON response.
stop_data.html - thymeleaf template page to render results. http://www.thymeleaf.org
gcc.css - CSS stylesheet

JSON
An example JSON response can be found at src/test/resources/gcc.json
