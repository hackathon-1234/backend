package com.hackathon2.main.services;

import com.hackathon2.main.repository.QuestionRepository;
import com.hackathon2.main.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    private final QuestionRepository questionRepository;

//    public Long create(TestDto dto) {
//        String name = dto.getName();
//        return testRepository.save(new Test(name)).getId();
//    }
}
