package com.andy.cgbshopbasicoauth2.support.oauth2;

import com.andy.cgbshopbasicoauth2.response.HttpResponse;
import com.andy.cgbshopbasicoauth2.utils.HttpUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuit
 * @date 2018/11/1 18:15
 *  请求拒绝，没有权限
 */
@Component
public class BootAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws IOException, ServletException {
        HttpUtils.writer(HttpResponse.baseResponse(HttpStatus.FORBIDDEN.value(),"没有权限"),response);
    }
}
