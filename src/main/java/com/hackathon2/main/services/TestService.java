package com.hackathon2.main.services;

import com.hackathon2.main.dto.QuestionDto;
import com.hackathon2.main.dto.TestDto;
import com.hackathon2.main.model.Answer;
import com.hackathon2.main.model.Question;
import com.hackathon2.main.model.Test;
import com.hackathon2.main.repository.AnswerRepository;
import com.hackathon2.main.repository.QuestionRepository;
import com.hackathon2.main.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public Iterable<Test> getAll() {
        return testRepository.findAll();
    }

    public Iterable<Test> getBySpecificationId(Long id) {
        return testRepository.findByActivityId(id);
    }

    public void create(TestDto testDto) {
        Long testId = testRepository.save(new Test(testDto.getActivityId())).getId();
        for (QuestionDto questionDto : testDto.getQuestions()) {
            int answerNumber = 0;
            Long questionId = questionRepository.save(new Question(questionDto.getName(), testId)).getId();
            for (String answer : questionDto.getAnswers()) {
                answerNumber += 1;
                answerRepository.save(new Answer(answer, questionId,
                        answerNumber == questionDto.getIsCorrect()));
            }
        }
    }

    public void delete(Long id) {
        testRepository.deleteById(id);
    }
}
