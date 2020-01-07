package com.andy.cgbshopbasicoauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableEurekaClient
@MapperScan("com.andy.cgbshopbasicoauth2.mapper")
public class CgbShopBasicOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(CgbShopBasicOauth2Application.class, args);
    }

}
