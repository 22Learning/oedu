package com.oedu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UmApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmApplication.class, args);
    }
}
