package com.andy.cgbshopserviceweixinimpl.serviceImpl;

import com.andy.cgbshopserviceapiweixin.demain.WeiXinApp;
import com.andy.cgbshopserviceapiweixin.service.GetAppService;
import com.sun.jersey.spi.container.ResourceFilters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GetAppServiceImpl implements GetAppService{

    @Value("${name}")
    private String name;

    @Override
    public String getApp() {
        WeiXinApp weiXinApp = new WeiXinApp();
        weiXinApp.setAge(28);
        weiXinApp.setName("yuanxin");
        return name;
//        return weiXinApp.toString();
    }
}
