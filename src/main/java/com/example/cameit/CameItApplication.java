package com.example.cameit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CameItApplication {

    public static void main(String[] args) {
        SpringApplication.run(CameItApplication.class, args);
    }

}
