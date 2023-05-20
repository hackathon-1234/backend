package com.hackathon2.main.repository;

import com.hackathon2.main.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findByTestId(@Param("test_id") Long testId);
}
