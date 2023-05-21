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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public Iterable<Test> getAll() {
        return testRepository.findAll();
    }

    public TestDto getByActivityId(Long activityId) {
        TestDto testDto = new TestDto();
        testDto.setActivityId(activityId);
        List<Test> tests = testRepository.findByActivityId(activityId);
        if (tests.size() == 0) return null;
        Long testId = tests.get(0).getId();
        List<Question> questions = questionRepository.findByTestId(testId);
        for (Question question: questions) {
            QuestionDto questionDto = new QuestionDto();
            List<Answer> answers = answerRepository.findByQuestionId(question.getId());
            questionDto.setAnswers(answers.stream().map(Answer::getName).collect(Collectors.toList()));
            questionDto.setName(question.getName());
        }
        return testDto;
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
