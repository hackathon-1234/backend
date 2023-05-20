package com.hackathon2.controller;

import com.hackathon2.main.model.Activity;
import com.hackathon2.main.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/activity")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping(value = "/get-all")
    public ResponseEntity<Iterable<Activity>> getAll() {
        return ResponseEntity.ok(activityService.getAll());
    }

    @PostMapping(value = "/new")
    public ResponseEntity<String> create(@RequestBody Activity activity) {
        activityService.create(activity);
        return ResponseEntity.ok("Успешно сохранено");
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        activityService.delete(id);
        return ResponseEntity.ok("Успешно удалено");
    }
}
