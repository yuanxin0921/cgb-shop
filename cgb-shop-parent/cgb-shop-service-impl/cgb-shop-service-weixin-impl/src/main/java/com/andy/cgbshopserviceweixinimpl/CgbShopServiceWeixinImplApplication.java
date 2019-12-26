package com.andy.cgbshopserviceweixinimpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CgbShopServiceWeixinImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgbShopServiceWeixinImplApplication.class, args);
    }

}
