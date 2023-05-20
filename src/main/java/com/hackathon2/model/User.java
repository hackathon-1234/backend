package com.hackathon2.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login")
    @NotBlank(message = "Логин не должен быть пустым")
    private String login;
    @Column(name = "password")
    @NotBlank(message = "Пароль не должен быть пустым")
    private String password;
    @Column(name = "first_name")
    @NotBlank(message = "Имя не должно быть пустым")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Фамилия не должна быть пустой")
    private String lastName;

    @Column(name = "father_name")
//    @NotBlank(message = "Отчество не должно быть пустым")
    private String fatherName;


    @Column(name = "email")
    @NotBlank(message = "Email не должен быть пустым")
    @Email(message = "Email должен быть корректным")
    private String email;


    @Column(name = "is_admin")
    private boolean isAdmin;

    @ManyToOne
    @JoinColumn(name = "specification_id", referencedColumnName = "id")
    private Specification specification;

    public User(String login, String password, String firstName, String lastName, String fatherName, String email, boolean isAdmin, Specification specification) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.email = email;
        this.isAdmin = isAdmin;
        this.specification = specification;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }
}
