package com.hackathon2.main.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class QuestionDto {
    private List<String> answers;
    private Integer isCorrect;
    private String name;
}
