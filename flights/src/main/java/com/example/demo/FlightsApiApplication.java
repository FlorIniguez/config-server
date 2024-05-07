package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//notacion para registar servicio
@EnableDiscoveryClient
public class FlightsApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(FlightsApiApplication.class, args);
    }


}


