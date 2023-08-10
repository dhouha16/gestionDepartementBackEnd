package com.example.appbackend.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.appbackend.dao.UsersDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Autowired
    AuthenticationManager authenticationManager;


    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    //pour faire l'authentification
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(login,password);
        return  authenticationManager.authenticate(authenticationToken);
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        //////////////
        //   super.successfulAuthentication(request, response, chain, authentication);
        ////////////////
        User user=(User)authentication.getPrincipal();
        Algorithm algorithm=Algorithm.HMAC256("secret".getBytes());
        //chaque 10min token expire
        List<String> roles=new ArrayList();
        authentication.getAuthorities().forEach(a->{
            roles.add(a.getAuthority());
        });
        String access_token= JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+10000*60*1000))
                .withIssuer(request.getRequestURL().toString())
                .withArrayClaim("role",roles.toArray(new String[roles.size()]))
                //   .withArrayClaim("admin",adminRepository.findByEmail(user.getUsername()))
                .sign(algorithm);
        //chaque 30min on fait un nouvel token
        response.setHeader("access_token",access_token);
        //pour que le reponse soit en body request pas dans le header
        Map<String, Object> tokens=new HashMap<>();
        tokens.put("acess_token",access_token);

        tokens.put("userName",user.getUsername());
        tokens.put("role",user.getAuthorities().stream().findFirst().get().getAuthority());
        // tokens.put("roles",user.getAuthorities().stream().findFirst().get().getAuthority());

        //  tokens.put("admin",adminRepository.findByEmail(user.getUsername()));
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(),tokens);
    }
}
