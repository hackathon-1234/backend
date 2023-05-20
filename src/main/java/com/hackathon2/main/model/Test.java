package com.hackathon2.main.model;

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
    @Column("activity_id")
    private Long activityId;

    public Test(Long activityId) {
        this.activityId = activityId;
    }
}
