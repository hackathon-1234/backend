package com.hackathon2.main.services;

import com.hackathon2.main.model.Decision;
import com.hackathon2.main.repository.DecisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DecisionService {

    private final DecisionRepository decisionRepository;

    public Iterable<Decision> getAll() {
        return decisionRepository.findAll();
    }

    public List<Decision> getByUserId(Long id) {
        return decisionRepository.findByUserId(id);
    }

    public Long create(Decision decision) {
        return decisionRepository.save(decision).getId();
    }

    public void delete(Long id) {
        decisionRepository.deleteById(id);
    }
}
