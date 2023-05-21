package com.hackathon2.main.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "material")
@NoArgsConstructor
public class Material {
    @Id
    @Column("id")
    private Long id;
    @Column("activity_id")
    private Long activityId;
    @Column("text")
    private String text;

    public Material(Long activityId, String text) {
        this.activityId = activityId;
        this.text = text;
    }
}
