package com.hackathon2.controller;

import com.hackathon2.main.dto.MaterialDto;
import com.hackathon2.main.model.Material;
import com.hackathon2.main.services.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/material")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService materialService;

    @GetMapping(value = "/get-all")
    public ResponseEntity<Iterable<Material>> getAll() {
        return ResponseEntity.ok(materialService.getAll());
    }

    @GetMapping(value = "/get")
    public ResponseEntity<MaterialDto> getByActivityId(@RequestParam Long activityId) {
        return ResponseEntity.ok(materialService.getByActivityId(activityId));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<String> create(@RequestBody MaterialDto dto) {
        materialService.create(dto);
        return ResponseEntity.ok("Успешно сохранено");
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        materialService.delete(id);
        return ResponseEntity.ok("Успешно удалено");
    }
}
