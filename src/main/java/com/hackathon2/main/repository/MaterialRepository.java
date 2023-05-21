package com.hackathon2.main.repository;

import com.hackathon2.main.model.Material;
import com.hackathon2.main.model.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long> {
    List<Material> findByActivityId(@Param("activity_id") Long activityId);
}
