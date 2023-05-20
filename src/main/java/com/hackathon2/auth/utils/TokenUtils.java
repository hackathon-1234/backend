package com.hackathon2.auth.utils;

import com.hackathon2.config.ParseOnlyJWTProcessor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.util.StringUtils;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public static String hashOf(String s)  {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert md != null;
        md.update(s.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter
                .printHexBinary(digest).toUpperCase();
    }
}
