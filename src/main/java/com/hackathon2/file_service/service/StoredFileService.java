package com.hackathon2.file_service.service;


import com.hackathon2.file_service.dto.StoredFileDto;

import java.io.FileNotFoundException;

public interface StoredFileService {
	
	Long create(StoredFileDto file);
	void update(Long id, StoredFileDto file) throws FileNotFoundException;
	StoredFileDto get(Long id) throws FileNotFoundException;
	String getName(Long id) throws FileNotFoundException;
	void upload(Long id,byte[] content) throws FileNotFoundException;
	byte[] download(Long id) throws FileNotFoundException;
	void delete(Long id);
	
}
