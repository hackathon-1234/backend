package com.hackathon2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "test")
@NoArgsConstructor
public class Test {
    @Id
    @Column("id")
    private Long id;
}
