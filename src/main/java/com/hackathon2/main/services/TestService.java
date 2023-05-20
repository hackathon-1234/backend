package com.hackathon2.main.services;

import com.hackathon2.main.model.Test;
import com.hackathon2.main.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public Iterable<Test> getAll() {
        return testRepository.findAll();
    }

    public Iterable<Test> getBySpecificationId(Long id) {
        return testRepository.findByActivityId(id);
    }

    public Long create(Test test) {
        return testRepository.save(test).getId();
    }

    public void delete(Long id) {
        testRepository.deleteById(id);
    }
}
