package com.hackathon2.config;

import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import org.springframework.security.oauth2.server.resource.introspection.OAuth2IntrospectionException;

import java.text.ParseException;

public class ParseOnlyJWTProcessor extends DefaultJWTProcessor<SecurityContext> {
    public JWTClaimsSet process(SignedJWT jwt, SecurityContext context) {
        try {
            return jwt.getJWTClaimsSet();
        } catch (ParseException e) {
            throw new OAuth2IntrospectionException(e.getMessage());
        }
    }
}