package com.andy.cgbshopbasicspringcloudeuraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan("com.andy")
public class CgbShopBasicSpringcloudEurakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgbShopBasicSpringcloudEurakaApplication.class, args);
    }

}
