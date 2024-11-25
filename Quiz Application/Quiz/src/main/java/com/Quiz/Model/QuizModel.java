package com.Quiz.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class QuizModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;


    @Column
    @ElementCollection
    private List<Integer> QuestionID;

    public QuizModel(Integer id, String title, List<Integer> questionID) {
        this.id = id;
        this.title = title;
        QuestionID = questionID;
    }

    public QuizModel() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getQuestions() {
        return QuestionID;
    }

    public void setQuestions(List<Integer> questions) {
        QuestionID = questions;
    }
}
