package com.hackathon2.main.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TestDto {
    private Long activityId;
    private List<QuestionDto> questions;
}
