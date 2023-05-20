package com.hackathon2.main.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "question")
@NoArgsConstructor
public class Question {
    @Id
    @Column("id")
    private Long id;
    @Column("name")
    private String name;
    @Column("test_id")
    private Long testId;

    public Question(String name, Long testId) {
        this.name = name;
        this.testId = testId;
    }
}
