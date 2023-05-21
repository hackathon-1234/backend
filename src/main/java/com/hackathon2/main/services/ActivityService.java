package com.hackathon2.main.services;

import com.hackathon2.main.model.Activity;
import com.hackathon2.main.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    public Iterable<Activity> getAll() {
        return activityRepository.findAll();
    }

    public List<Activity> getBySpecificationId(Long id) {
        return activityRepository.findBySpecificationId(id);
    }

    public Long create(Activity activity) {
        return activityRepository.save(activity).getId();
    }

    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
}
