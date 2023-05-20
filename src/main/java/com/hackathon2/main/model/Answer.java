package com.hackathon2.main.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "answer")
@NoArgsConstructor
public class Answer {
    @Id
    @Column("id")
    private Long id;
    @Column("name")
    private String name;
    @Column("is_correct")
    private Boolean isCorrect;
    @Column("question_id")
    private Long questionId;

    public Answer(String name, Long questionId, Boolean isCorrect) {
        this.name = name;
        this.questionId = questionId;
        this.isCorrect = isCorrect;
    }
}
