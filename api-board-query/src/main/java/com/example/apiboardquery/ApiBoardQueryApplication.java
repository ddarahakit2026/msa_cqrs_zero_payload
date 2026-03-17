package com.example.apiboardquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiBoardQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBoardQueryApplication.class, args);
    }

}
