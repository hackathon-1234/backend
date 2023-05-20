//package com.hackathon2.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "answer")
//public class Answer {
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "is_correct")
//    private boolean isCorrect;
//
//    @ManyToOne
//    @JoinColumn(name = "question_id", referencedColumnName = "id")
//    private Question question;
//
//    public Answer(String name, boolean isCorrect, Question question) {
//        this.name = name;
//        this.isCorrect = isCorrect;
//        this.question = question;
//    }
//
//    public Answer() {
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
//    public boolean isCorrect() {
//        return isCorrect;
//    }
//
//    public void setCorrect(boolean correct) {
//        isCorrect = correct;
//    }
//
//    public Question getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(Question question) {
//        this.question = question;
//    }
//}
