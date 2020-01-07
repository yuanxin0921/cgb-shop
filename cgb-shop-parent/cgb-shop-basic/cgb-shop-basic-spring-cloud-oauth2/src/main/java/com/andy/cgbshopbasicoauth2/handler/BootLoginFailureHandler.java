package com.andy.cgbshopbasicoauth2.handler;

import com.andy.cgbshopbasicoauth2.support.BootSecurityProperties;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuit
 * @date 2018/11/6 17:45
 *
 */
@Component
public class BootLoginFailureHandler implements AuthenticationFailureHandler {

    private BootSecurityProperties properties;

    public BootLoginFailureHandler(BootSecurityProperties properties) {
        this.properties = properties;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
            request.setAttribute("error",exception.getMessage());
            request.getRequestDispatcher(properties.getLoginPage()).forward(request,response);
    }
}
