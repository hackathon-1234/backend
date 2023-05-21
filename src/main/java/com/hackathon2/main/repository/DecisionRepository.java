package com.hackathon2.main.repository;

import com.hackathon2.main.model.Decision;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecisionRepository extends CrudRepository<Decision, Long> {
    List<Decision> findByUserId(@Param("user_id") Long userId);
}
