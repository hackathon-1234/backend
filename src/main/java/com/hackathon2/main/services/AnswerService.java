package com.hackathon2.main.services;

import com.hackathon2.main.model.Answer;
import com.hackathon2.main.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Iterable<Answer> getAll() {
        return answerRepository.findAll();
    }

    public Iterable<Answer> getBySpecificationId(Long id) {
        return answerRepository.findByQuestionId(id);
    }

    public Long create(Answer answer) {
        return answerRepository.save(answer).getId();
    }

    public void delete(Long id) {
        answerRepository.deleteById(id);
    }
}
