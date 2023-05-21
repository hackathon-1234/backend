package com.hackathon2.main.services;

import com.hackathon2.file_service.domain.StoredFile;
import com.hackathon2.file_service.repo.StoredFileRepository;
import com.hackathon2.main.dto.MaterialDto;
import com.hackathon2.main.model.Material;
import com.hackathon2.main.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final StoredFileRepository storedFileRepository;

    public Iterable<Material> getAll() {
        return materialRepository.findAll();
    }

    public MaterialDto getByActivityId(Long activityId) {
        MaterialDto materialDto = new MaterialDto();
        materialDto.setActivityId(activityId);
        List<Material> materials = materialRepository.findByActivityId(activityId);
        if (materials.size() == 0) return null;
        materialDto.setText(materials.get(0).getText());
        Long materialId = materials.get(0).getId();

        List<StoredFile> files = storedFileRepository.findByMaterialId(materialId);
        materialDto.setFiles(files);
        return materialDto;
    }

    public void create(MaterialDto materialDto) {
        Long materialId = materialRepository.save(
                new Material(materialDto.getActivityId(), materialDto.getText())).getId();
        //TODO: сохранение файлов
    }

    public void delete(Long id) {
        materialRepository.deleteById(id);
    }
}
