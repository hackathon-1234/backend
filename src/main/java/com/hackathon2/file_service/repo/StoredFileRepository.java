package com.hackathon2.file_service.repo;

import com.hackathon2.file_service.domain.StoredFile;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StoredFileRepository extends CrudRepository<StoredFile, Long> {
	@Query("select id, name from files")
	Iterable<StoredFile> findFilesList();

//	@Query("select * from tests where activity_id = :id")
//	List<StoredFile> findByParentId(@Param("id") Long id);

}
