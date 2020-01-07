package com.andy.cgbshopbasicoauth2.support.oauth2;

import com.andy.cgbshopbasicoauth2.response.HttpResponse;
import com.andy.cgbshopbasicoauth2.utils.HttpUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuit
 * @date 2018/11/2 10:48
 *
 */
@Component
public class BootOAuth2AuthExceptionEntryPoint extends OAuth2AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        HttpUtils.writer(HttpResponse.baseResponse(HttpStatus.UNAUTHORIZED.value(),e.getMessage()),response);
    }

}
