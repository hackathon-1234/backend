package com.hackathon2.controller;

import com.hackathon2.main.model.Decision;
import com.hackathon2.main.services.DecisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/decision")
@RequiredArgsConstructor
public class DecisionController {

    private final DecisionService decisionService;

    @GetMapping(value = "/get-all")
    public ResponseEntity<Iterable<Decision>> getAll() {
        return ResponseEntity.ok(decisionService.getAll());
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<Decision>> getByUserId(@RequestParam Long specificationId) {
        return ResponseEntity.ok(decisionService.getByUserId(specificationId));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<String> create(@RequestBody Decision decision) {
        decisionService.create(decision);
        return ResponseEntity.ok("Успешно сохранено");
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        decisionService.delete(id);
        return ResponseEntity.ok("Успешно удалено");
    }
}
