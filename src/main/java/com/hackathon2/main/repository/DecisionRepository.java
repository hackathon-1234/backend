package com.hackathon2.main.repository;

import com.hackathon2.main.model.Decision;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionRepository extends CrudRepository<Decision, Long> {

}
