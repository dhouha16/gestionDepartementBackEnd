package com.example.appbackend.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class CustomAutorisationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,authorization");
        response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
        response.addHeader("Access-Control-Expose-Methods", "POST,GET,PUT,DELETE,PATCH");
        response.addHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE,PATCH");
        if(request.getServletPath().equals("/admin/login") ||request.getServletPath().equals("/admin/token/refresh")  ){
            filterChain.doFilter(request,response);
        } else{
            String autorisationHeader=request.getHeader(AUTHORIZATION);
            //si le internaut autoriser et il renvoi le token au backend il utilise le nom "Bearer"
            if(autorisationHeader!=null && autorisationHeader.startsWith("Bearer ")){
                //  try {
                String token=autorisationHeader.substring("Bearer ".length());
                Algorithm algorithm=Algorithm.HMAC256("secret".getBytes());
                //pour verfier le token
                JWTVerifier verifierfier= JWT.require(algorithm)
                        .build();
                DecodedJWT decodedJWT= verifierfier.verify(token);
                //grab user
                String email=decodedJWT.getSubject();
                //get role
                filterChain.doFilter(request,response);
            }else {
                filterChain.doFilter(request,response);
            }
        }

    }
}

