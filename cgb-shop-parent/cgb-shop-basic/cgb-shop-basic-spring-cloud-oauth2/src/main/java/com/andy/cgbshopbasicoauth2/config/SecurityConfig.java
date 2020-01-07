package com.andy.cgbshopbasicoauth2.config;

import com.andy.cgbshopbasicoauth2.filter.BootPictureCodeAuthenticationFilter;
import com.andy.cgbshopbasicoauth2.handler.BootLoginFailureHandler;
import com.andy.cgbshopbasicoauth2.sms.SmsAuthenticationProvider;
import com.andy.cgbshopbasicoauth2.sms.SmsSecurityConfig;
import com.andy.cgbshopbasicoauth2.support.BootSecurityProperties;
import com.andy.cgbshopbasicoauth2.support.BootUserDetailService;
import com.andy.cgbshopbasicoauth2.support.code.BootCodeService;
import com.andy.cgbshopbasicoauth2.support.properities.BootBaseLoginProperties;
import com.andy.cgbshopbasicoauth2.support.properities.BootSmsLoginProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author yuit
 * @date 2018/10/10  11:48
 **/
@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    private BootUserDetailService userDetailService;
    private BootSecurityProperties properties;
    private BootLoginFailureHandler handler;
    private SmsSecurityConfig smsSecurityConfig;
    private BootPictureCodeAuthenticationFilter pictureCodeAuthenticationFilter;


    public SecurityConfig(BootUserDetailService userDetailService,
                          BootSecurityProperties properties,
                          BootLoginFailureHandler handler,
                          SmsSecurityConfig smsSecurityConfig,
                          BootCodeService<String> codeService) {
        this.userDetailService = userDetailService;
        this.properties = properties;
        this.handler = handler;
        this.smsSecurityConfig = smsSecurityConfig;
        pictureCodeAuthenticationFilter = new BootPictureCodeAuthenticationFilter(properties,codeService, handler);
    }

    /**
     * 让Security 忽略这些url，不做拦截处理
     *
     * @param
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers
                ("/swagger-ui.html/**", "/webjars/**",
                        "/swagger-resources/**", "/v2/api-docs/**",
                        "/swagger-resources/configuration/ui/**","/statics/**",properties.getCodePath(), "/swagger-resources/configuration/security/**",
                        "/images/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        BootBaseLoginProperties base = properties.getBaseLogin();
        BootSmsLoginProperties sms = properties.getSmsLogin();
        http
                // http security 要拦截的url，这里这拦截，oauth2相关和登录登录相关的url，其他的交给资源服务处理
                .requestMatchers()
                .antMatchers( "/oauth/**",properties.getLoginPage(),
                        base.getLoginProcessUrl(),sms.getLoginProcessUrl())
                .and()
                .authorizeRequests()
                // 自定义页面或处理url是，如果不配置全局允许，浏览器会提示服务器将页面转发多次
                .antMatchers(properties.getLoginPage(),base.getLoginProcessUrl(),sms.getLoginProcessUrl())
                .permitAll()
                .anyRequest()
                .authenticated();

        // 表单登录
        http.formLogin()
                .failureHandler(handler)
                // 请求 {用户名} 参数名称
                .usernameParameter(base.getUsernameParameterName())
                // 请求 {密码} 参数名
                .passwordParameter(base.getPasswordParameterName())
                // 登录页面
                .loginPage(properties.getLoginPage())
                // 登录处理url
                .loginProcessingUrl(base.getLoginProcessUrl());

        http.httpBasic().disable();

        http.apply(this.smsSecurityConfig);

        // 用户密码验证之前校验验证码
        http.addFilterBefore(pictureCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SmsAuthenticationProvider smsAuthenticationProvider (){
        return new SmsAuthenticationProvider();
    }
}
