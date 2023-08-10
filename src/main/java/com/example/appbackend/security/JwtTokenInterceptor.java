package com.example.appbackend.security;

import com.example.appbackend.dao.UsersDao;
import com.example.appbackend.security.filter.JwtToken;
import com.example.appbackend.security.filter.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class JwtTokenInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        JwtToken annotation;
        System.out.println("----------------");
        if (handler instanceof HandlerMethod) {
            System.out.println("+++++++++++++++++++++");
            annotation = ((HandlerMethod) handler).getMethodAnnotation(JwtToken.class);
        } else {
            return true;
        }
        // If there is no such comment, let go directly
        if (annotation == null) {
            return true;
        }
        // Verification token
        ResponseResult res = JwtUtil.verity();
         System.out.println("*********** "+res.getCode());
        if (200 == res.getCode()) {
            //System.out.println("--------------------------------- 200");
            return true;
        }
        // If the verification fails, 401 is returned, indicating that the user is not logged in
        System.out.println("--------------------------------- 401");

        response.setStatus(401);
        return false;
    }
}
