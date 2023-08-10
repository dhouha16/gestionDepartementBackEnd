package com.example.appbackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig  implements WebMvcConfigurer {
    @Autowired
    private JwtTokenInterceptor authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Register blocking rules
        InterceptorRegistration ir = registry.addInterceptor(authorizationInterceptor);
        // Interception path, all paths for open api requests are intercepted
        ir.addPathPatterns("/departement/**","/project/**", "/role/**", "/tasks/**", "/user/**");
        // Do not intercept paths, such as: register, log in, forget password, etc.
        // ir.excludePathPatterns("/api/userInfo/doRegister", "/api/userInfo/doLoginByAccount", "/api/userInfo/doLoginByPhone", "/api/userInfo/updatePasswordForget");
    }
}
