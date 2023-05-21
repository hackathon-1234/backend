package com.hackathon2.file_service.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("files")
@Builder
public class StoredFile {

    @Id
    @Column("id")
    private Long id;
    @Column("name")
    private String name;
    @Column("content")
    private byte[] content;
    @Column("material_id")
    private Long materialId;
}
