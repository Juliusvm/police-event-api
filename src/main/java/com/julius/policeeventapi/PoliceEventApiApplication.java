package com.julius.policeeventapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PoliceEventApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoliceEventApiApplication.class, args);
    }

}
