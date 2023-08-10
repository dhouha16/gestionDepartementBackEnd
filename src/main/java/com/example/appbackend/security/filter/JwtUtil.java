package com.example.appbackend.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.appbackend.security.ResponseResult;
import com.example.appbackend.security.SpringContextUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtil {
    /**
     * Verify token and parse token
     */
    public static ResponseResult verity() {
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        // Get the token information from the request header
        String autorisationHeader = request.getHeader("Authorization");
        if (StringUtils.isBlank(autorisationHeader)) {
            return ResponseResult.error(401, "User information has expired，please login again");
        }
        try {
            if (autorisationHeader != null && autorisationHeader.startsWith("Bearer ")) {

                String token = autorisationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT jwt = verifier.verify(token);

                if (null != jwt) {
                    // Get the information we placed in the token
                    String email = jwt.getSubject();
               System.out.println("++++++++++++++++** "+jwt.getExpiresAt().after(new Date()));
                    if (email!=null && jwt.getExpiresAt().after(new Date())) {
                        return ResponseResult.success("Authentication is successful");
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
        return ResponseResult.error(401, "User information has expired, please log in again");
    }
}
