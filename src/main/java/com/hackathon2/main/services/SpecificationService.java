package com.hackathon2.main.services;

import com.hackathon2.main.model.Specification;
import com.hackathon2.main.repository.QuestionRepository;
import com.hackathon2.main.repository.SpecificationRepository;
import com.hackathon2.main.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecificationService {

    private final SpecificationRepository specificationRepository;

    public Iterable<Specification> getAll() {
        return specificationRepository.findAll();
    }

    public Long create(String name) {
        return specificationRepository.save(new Specification(name)).getId();
    }

    public void delete(Long id) {
        specificationRepository.deleteById(id);
    }
}
