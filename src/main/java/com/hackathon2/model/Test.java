//package com.hackathon2.model;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "test")
//public class Test {
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "activity_id", referencedColumnName = "id")
//    private Activity activity;
//
//    @OneToMany(mappedBy = "test")
//    private List<Question> questions;
//
//    public Test(Activity activity, List<Question> questions) {
//        this.activity = activity;
//        this.questions = questions;
//    }
//
//    public Test() {
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
//    public Activity getActivity() {
//        return activity;
//    }
//
//    public void setActivity(Activity activity) {
//        this.activity = activity;
//    }
//
//    public List<Question> getQuestions() {
//        return questions;
//    }
//
//    public void setQuestions(List<Question> questions) {
//        this.questions = questions;
//    }
//}
