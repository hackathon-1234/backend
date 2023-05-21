package com.hackathon2.controller;

import com.hackathon2.file_service.domain.StoredFile;
import com.hackathon2.file_service.dto.StoredFileDto;
import com.hackathon2.file_service.service.StoredFileService;
import com.hackathon2.main.model.Specification;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

@RequestMapping("/file")
@Controller
public class StoredFileController {
	
	private final StoredFileService storedFileService;

    public StoredFileController(StoredFileService storedFileService) {
		this.storedFileService = storedFileService;
	}

	@PostMapping(value = "/new",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createFile (@RequestParam("material_id") Long materialId,
											  @RequestParam("file") MultipartFile file) throws IOException {
		storedFileService.create(file, materialId);
        return ResponseEntity.ok("Файл успешно сохранен");
    }

	@GetMapping(value = "/get-all")
	public ResponseEntity<Iterable<StoredFile>> getAll() {
		return ResponseEntity.ok(storedFileService.getAll());
	}

	@PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadFile (@RequestParam("id") Long id,
    		@RequestParam("file") MultipartFile file) {
    	try {
			storedFileService.upload(id, file.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ResponseEntity.ok().build();
    }
	
    @GetMapping(value="/public", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> download(@RequestParam("id") Long id,
    		HttpServletResponse response) {
		if (id == null){
			return ResponseEntity.noContent().build();
		} else {
			try {
				byte[] c = storedFileService.download(id);
				String fileName = storedFileService.getName(id);
				ContentDisposition contentDisposition = ContentDisposition.builder("inline").filename(fileName).build();
				HttpHeaders headers = new HttpHeaders();
				headers.setContentDisposition(contentDisposition);
				return ResponseEntity.ok()
						.headers(headers)
						.contentType(MediaType.APPLICATION_OCTET_STREAM)
						.body(c);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.noContent().build();
			}
		}
    }

	@DeleteMapping(value = "/file", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteByid(@RequestParam("id") Long id) throws Exception {
		storedFileService.delete(id);
		return ResponseEntity.ok("Successfully deleted");
	}

}
