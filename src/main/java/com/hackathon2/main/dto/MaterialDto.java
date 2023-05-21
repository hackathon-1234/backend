package com.hackathon2.main.dto;

import com.hackathon2.file_service.domain.StoredFile;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MaterialDto {
    private Long activityId;
    private String text;
    private List<StoredFile> files;
}
