package com.hackathon2.controller;

import com.hackathon2.main.model.Specification;
import com.hackathon2.main.services.SpecificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/specification")
@RequiredArgsConstructor
public class SpecificationController {

    private final SpecificationService specificationService;

    @GetMapping(value = "/new",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Specification>> getAll() {
        return ResponseEntity.ok(specificationService.getAll());
    }

    @PostMapping(value = "/new",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestParam String name) {
        specificationService.create(name);
        return ResponseEntity.ok("Успешно сохранено");
    }

    @PostMapping(value = "/new",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@RequestParam Long id) {
        specificationService.delete(id);
        return ResponseEntity.ok("Успешно удалено");
    }
}
