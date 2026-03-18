package com.example.apiboardcomposition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiBoardCompositionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBoardCompositionApplication.class, args);
    }

}
