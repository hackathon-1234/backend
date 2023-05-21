package com.hackathon2.file_service.service;

import com.hackathon2.file_service.domain.StoredFile;
import com.hackathon2.file_service.dto.StoredFileDto;
import com.hackathon2.file_service.repo.StoredFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StoredFileServiceImpl implements StoredFileService {

	private final StoredFileRepository storedFileRepository;

	private static final String ERROR_MESSAGE = "File to update not found";

	public StoredFileServiceImpl(StoredFileRepository storedFileRepository) {
		this.storedFileRepository = storedFileRepository;
	}

	@Override
	public Iterable<StoredFile> getAll() {
		return storedFileRepository.findFilesList();
	}

	@Override
	public void create(MultipartFile file, Long materialId) throws IOException {
		StoredFile f = StoredFile.builder()
				.name(file.getName())
				.materialId(materialId)
				.build();

		Long fileId = storedFileRepository.save(f).getId();

		upload(fileId, file.getBytes());
	}

	@Override
	public void upload(Long id, byte[] content) throws FileNotFoundException {
		Optional<StoredFile> oFile = storedFileRepository.findById(id);
		if (oFile.isEmpty()) {
			throw new FileNotFoundException(String.format(ERROR_MESSAGE,id));
		}
		else {
			StoredFile file = oFile.get();
			file.setContent(content);
			storedFileRepository.save(file);
		}

	}

	@Override
	public void update(Long id, StoredFileDto f) throws FileNotFoundException {
		Optional<StoredFile> oFile = storedFileRepository.findById(id);
		if (oFile.isEmpty()) {
			throw new FileNotFoundException(String.format(ERROR_MESSAGE,id));
		}
		else {
			StoredFile file = oFile.get();
			file.setName(f.getName());
			storedFileRepository.save(file);
		}
	}

	@Override
	public StoredFileDto get(Long id) throws FileNotFoundException {
		Optional<StoredFile> oFile = storedFileRepository.findById(id);
		if (oFile.isEmpty()) {
			throw new FileNotFoundException(String.format(ERROR_MESSAGE,id));
		}
		else {
			StoredFile f = oFile.get();
			return StoredFileDto.builder()
					.name(f.getName())
					.build();
		}
	}

	@Override
	public String getName(Long id) throws FileNotFoundException {
		Optional<StoredFile> oFile = storedFileRepository.findById(id);
		if (oFile.isEmpty()) {
			throw new FileNotFoundException(String.format(ERROR_MESSAGE,id));
		}
		else {
			StoredFile f = oFile.get();
			return f.getName();
		}
	}

	@Override
	public byte[] download(Long id) throws FileNotFoundException {
		Optional<StoredFile> oFile = storedFileRepository.findById(id);
		if (oFile.isEmpty()) {
			throw new FileNotFoundException(String.format(ERROR_MESSAGE,id));
		}
		else {
			return oFile.get().getContent();
		}
	}

	@Override
	public void delete(Long id) throws Exception {
		StoredFile storedFile = storedFileRepository.findById(id)
				.orElseThrow(Exception::new);
		storedFileRepository.delete(storedFile);
	}

	public List<StoredFile> getByMaterialId(Long materialId) throws Exception {
		return storedFileRepository.findByMaterialId(materialId);
	}
}
