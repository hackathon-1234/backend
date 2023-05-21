package com.hackathon2.file_service.service;


import com.hackathon2.file_service.domain.StoredFile;
import com.hackathon2.file_service.dto.StoredFileDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface StoredFileService {
	
	void create(MultipartFile file, Long materialId) throws IOException;
	void update(Long id, StoredFileDto file) throws FileNotFoundException;
	StoredFileDto get(Long id) throws FileNotFoundException;
	String getName(Long id) throws FileNotFoundException;
	void upload(Long id,byte[] content) throws FileNotFoundException;
	byte[] download(Long id) throws FileNotFoundException;
	void delete(Long id) throws Exception;

	Iterable<StoredFile> getAll();
	List<StoredFile> getByMaterialId(Long materialId);
	
}
