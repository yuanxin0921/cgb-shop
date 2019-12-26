package com.andy.cgbshopserviceapimember.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface MemberService {

    @GetMapping("/memberInvokeWeixin")
    public String memberInvokeWeixin();

}
