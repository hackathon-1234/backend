package com.hackathon2.auth.repository;

import com.hackathon2.model.Question;
import liquibase.pro.packaged.R;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
