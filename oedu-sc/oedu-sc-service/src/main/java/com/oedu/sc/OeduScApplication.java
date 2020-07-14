package com.oedu.sc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@ServletComponentScan
@EnableFeignClients
@MapperScan("com.oedu.sc.**.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class OeduScApplication {
    public static void main(String[] args) {
        SpringApplication.run(OeduScApplication.class,args);
    }
}
