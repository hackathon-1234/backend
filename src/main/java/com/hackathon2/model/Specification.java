//package com.hackathon2.model;
//
//import com.hackathon2.auth.data.User;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "specification")
//public class Specification {
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name")
//    private String name;
//
//    // не используется
//    @OneToMany(mappedBy = "specification")
//    private List<User> users;
//
//    //    не используется
//    @OneToMany(mappedBy = "specification")
//    private List<Activity> activities;
//
//    public Specification(String name, List<User> users) {
//        this.name = name;
//        this.users = users;
//    }
//
//    public Specification() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//}
