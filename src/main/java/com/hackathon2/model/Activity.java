package com.hackathon2.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "specification_id", referencedColumnName = "id")
    private Specification specification;

    public Activity(String name, Specification specification) {
        this.name = name;
        this.specification = specification;
    }

    public Activity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }
}
