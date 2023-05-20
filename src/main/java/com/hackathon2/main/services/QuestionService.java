package com.hackathon2.main.services;

import com.hackathon2.main.model.Question;
import com.hackathon2.main.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Iterable<Question> getAll() {
        return questionRepository.findAll();
    }

    public Iterable<Question> getBySpecificationId(Long id) {
        return questionRepository.findByTestId(id);
    }

    public Long create(Question question) {
        return questionRepository.save(question).getId();
    }

    public void delete(Long id) {
        questionRepository.deleteById(id);
    }
}
