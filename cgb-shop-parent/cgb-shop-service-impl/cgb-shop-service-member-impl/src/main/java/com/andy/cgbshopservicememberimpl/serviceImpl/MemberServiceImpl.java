package com.andy.cgbshopservicememberimpl.serviceImpl;

import com.andy.cgbshopserviceapimember.service.MemberService;
import com.andy.cgbshopservicememberimpl.serviceFeign.WeixinAppServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MemberServiceImpl implements MemberService {

    @Autowired
    WeixinAppServiceFeign weixinAppServiceFeign;

    @Value("${age}")
    private String age;

    @Override
    public String memberInvokeWeixin() {

        return age;
//        return weixinAppServiceFeign.getApp();
    }
}
