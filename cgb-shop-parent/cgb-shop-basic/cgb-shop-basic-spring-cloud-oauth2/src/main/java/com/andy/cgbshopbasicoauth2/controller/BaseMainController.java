package com.andy.cgbshopbasicoauth2.controller;

import com.andy.cgbshopbasicoauth2.support.BootSecurityProperties;
import com.andy.cgbshopbasicoauth2.support.properities.BootBaseLoginProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuit
 * @date 2018/10/9  15:09
 **/
@Controller
@Slf4j
public class BaseMainController {


    private BootSecurityProperties properties;


    public BaseMainController(BootSecurityProperties properties) {
        this.properties = properties;
    }

    @RequestMapping("${boot.oauth.login-page:/auth/login}")
    public String loginPage(Model model, HttpServletRequest request) {
        BootBaseLoginProperties base = properties.getBaseLogin();
        String type = request.getParameter("type");

        model.addAttribute("username", request.getParameter(base.getUsernameParameterName()));
        model.addAttribute("password", request.getParameter(base.getPasswordParameterName()));
        model.addAttribute("error", request.getAttribute("error"));
        if (type != null
                && (type.equalsIgnoreCase("base")
                || type.equalsIgnoreCase("sms")
                || type.equalsIgnoreCase("social"))) {
            model.addAttribute("type", type);
        } else {
            model.addAttribute("type", "base");
        }

        model.addAttribute("sms", properties.getSmsLogin());
        model.addAttribute("base", properties.getBaseLogin());
        model.addAttribute("codePath", properties.getCodePath());
        return "base-login";
    }


}
