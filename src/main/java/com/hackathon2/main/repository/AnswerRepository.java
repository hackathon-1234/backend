package com.hackathon2.main.repository;

import com.hackathon2.main.model.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findByQuestionId(@Param("question_id") Long questionId);

}
