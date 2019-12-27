package com.andy.cgbshopbasicspringcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
@ServletComponentScan(basePackages = "com.andy.cgbshopbasicspringcloudconfigserver.filter")
public class CgbShopBasicSpringCloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgbShopBasicSpringCloudConfigServerApplication.class, args);
    }

}
