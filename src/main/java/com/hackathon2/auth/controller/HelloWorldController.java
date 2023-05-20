package com.hackathon2.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping
    public ResponseEntity<String> sendHello() {
        return ResponseEntity.ok("Hello world");
    }

}
