package com.hackathon2.controller;

import com.hackathon2.main.dto.TestDto;
import com.hackathon2.main.model.Test;
import com.hackathon2.main.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping(value = "/get-all")
    public ResponseEntity<Iterable<Test>> getAll() {
        return ResponseEntity.ok(testService.getAll());
    }

    @PostMapping(value = "/new")
    public ResponseEntity<String> create(@RequestBody TestDto dto) {
        testService.create(dto);
        return ResponseEntity.ok("Успешно сохранено");
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        testService.delete(id);
        return ResponseEntity.ok("Успешно удалено");
    }
}
