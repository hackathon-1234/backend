package com.hackathon2.main.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "specification")
@NoArgsConstructor
public class Specification {
    @Id
    @Column("id")
    private Long id;
    @Column("name")
    private String name;

    public Specification(String name) {
        this.name = name;
    }
}
