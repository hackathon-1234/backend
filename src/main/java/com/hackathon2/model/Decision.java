package com.hackathon2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table(name = "decision")
@NoArgsConstructor
public class Decision {
    @Id
    @Column("id")
    private Long id;

    @Column("user_id")
    private Long userId;

    @Column("test_id")
    private Long testId;

    @Column("time_of_decision")
    private LocalDate timeOfDecision;

    @Column("count_of_right_answers")
    private Integer countOfRightAnswers;

    @Column("count_of_all_answers")
    private Integer countOfAllAnswers;


}
