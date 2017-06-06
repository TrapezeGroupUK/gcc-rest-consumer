package com.trapezegroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public String baseUrl() {
        return "http://trp-slo-glocs0:9090/StopEvents?Atcocode="; // This should be the baseURL as supplied by Trapeze. Please ensure that URL ends with /
    }

    @Bean
    public String userKey() {
        return ""; //This should be your user_key supplied by Trapeze
    }

    @Bean
    public int readTimeoutSecs() {
        return 30; // read timeout in seconds for the rest service
    }

    @Bean
    public int connectTimeoutSecs() {
        return 30; // connect timeout in seconds for the rest service
    }

    @Bean
    public Map<String, String> stops() {
        Map<String, String> stopsAndBays = new HashMap<String, String>();

        stopsAndBays.put("1600GLA57077", "A");
        stopsAndBays.put("1600GLA57078", "B");
        stopsAndBays.put("1600GLA57079", "C");
        stopsAndBays.put("1600GLA57080", "D");
        stopsAndBays.put("1600GLA57081", "E");
        stopsAndBays.put("1600GLA57082", "F");
        stopsAndBays.put("1600GL2150", "G");
        stopsAndBays.put("1600GLA57083", "H");
        stopsAndBays.put("1600GLA57084", "I");
        stopsAndBays.put("1600GLA57085", "J");
        stopsAndBays.put("1600GLA57086", "K");

        return stopsAndBays;
    }

}
