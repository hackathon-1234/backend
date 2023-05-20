package com.hackathon2.file_service.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoredFileDto {

    private Long id;
    private String name;
    private byte[] content;
    private Long parentId;
}
