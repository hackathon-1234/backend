package com.hackathon2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "activity")
@NoArgsConstructor
public class Activity {
    @Id
    @Column("id")
    private Long id;
    @Column("name")
    private String name;

    public Activity(String name) {
        this.name = name;
    }
}

