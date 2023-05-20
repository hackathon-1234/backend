package com.hackathon2.main.repository;

import com.hackathon2.main.model.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

    List<Activity> findBySpecificationId(@Param("specification_id") Long specificationId);
}
