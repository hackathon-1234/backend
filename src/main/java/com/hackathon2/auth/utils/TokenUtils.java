package com.hackathon2.auth.utils;

import com.hackathon2.config.ParseOnlyJWTProcessor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.util.StringUtils;

public class TokenUtils {

    private static final JwtDecoder jwtDecoder = new NimbusJwtDecoder(new ParseOnlyJWTProcessor());

    public static String getUsernameFromToken(String authHeader){
        String token = StringUtils.delete(authHeader, "Bearer ");
        Jwt jwt = jwtDecoder.decode(token);
        return (String) jwt.getClaims().get("username");
    }

    public static String getAuthTypeFromToken(String authHeader){
        String token = StringUtils.delete(authHeader, "Bearer ");
        Jwt jwt = jwtDecoder.decode(token);
        return (String) jwt.getClaims().get("is_admin");
    }
}
