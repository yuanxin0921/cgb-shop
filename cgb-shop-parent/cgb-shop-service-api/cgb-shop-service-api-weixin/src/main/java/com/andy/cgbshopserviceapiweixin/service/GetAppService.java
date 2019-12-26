package com.andy.cgbshopserviceapiweixin.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface GetAppService {

    @GetMapping("/getApps")
    public String getApp();
}
