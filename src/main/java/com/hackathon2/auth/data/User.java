package com.hackathon2.auth.data;

import com.hackathon2.model.Specification;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("user")
@NoArgsConstructor
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    private boolean isAdmin;
    private String email;
    private String firstName;
    private String lastName;
    private String fatherName;

    public User(String username, String password, boolean isAdmin, String email, String firstName, String lastName, String fatherName) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}
