package com.trapezegroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public String baseUrl() {
        return ""; // This should be the baseURL as supplied by Trapeze. Please ensure that URL ends with /
    }

    @Bean
    public String userKey() {
        return ""; //This should be your user_key supplied by Trapeze
    }

}
