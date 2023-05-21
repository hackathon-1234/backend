package com.hackathon2.controller;

import com.hackathon2.auth.data.User;
import com.hackathon2.auth.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/token")
@Controller
public class TokenController {

    private final TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    @GetMapping
    public ResponseEntity<?> getToken(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "password") String password) {
        try {
            return ResponseEntity.ok(tokenService.generateToken(new User(username, password)));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    //TODO: refresh
//    @GetMapping(value = "/refresh", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> refreshToken(@RequestHeader("Authorization") String authHeader) {
//
//        return ResponseEntity.ok(
//                tokenService.refreshToken(
//                        TokenUtils.getUsernameFromToken(authHeader),
//                        TokenUtils.getRole(authHeader),
//    }

}
