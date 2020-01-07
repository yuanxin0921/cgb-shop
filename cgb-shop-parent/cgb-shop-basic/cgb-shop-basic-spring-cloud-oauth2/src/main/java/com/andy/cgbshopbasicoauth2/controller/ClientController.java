package com.andy.cgbshopbasicoauth2.controller;

import com.andy.cgbshopbasicoauth2.entity.Client;
import com.andy.cgbshopbasicoauth2.response.BaseResponse;
import com.andy.cgbshopbasicoauth2.response.HttpResponse;
import com.andy.cgbshopbasicoauth2.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yuit
 * @date 2018/10/16  10:32
 *
 **/
@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public BaseResponse clientRegistered(@RequestBody @Valid Client client) {

        client.setClientSecret(passwordEncoder.encode(client.getClientSecret()));
        boolean i = clientService.save(client);
        return HttpResponse.baseResponse(200);
    }

}
