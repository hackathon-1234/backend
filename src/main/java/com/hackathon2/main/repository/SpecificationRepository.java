package com.hackathon2.main.repository;

import com.hackathon2.main.model.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificationRepository extends CrudRepository<Specification, Long> {

}
