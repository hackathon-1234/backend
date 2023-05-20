package com.hackathon2.controller;

import com.hackathon2.main.dto.TestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody TestDto testDto) {
        return null;
    }
}
