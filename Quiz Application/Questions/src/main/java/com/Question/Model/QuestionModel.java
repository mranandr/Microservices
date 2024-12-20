package com.Question.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Data
@Table(name="Questions")
public class QuestionModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column
    @NotNull
    @NotBlank
    private String question;

    @Column
    @NotNull
    @NotBlank
    private String option1;

    @Column
    @NotNull
    @NotBlank
    private String option2;

    @Column
    @NotNull
    @NotBlank
    private String option3;

    @Column
    @NotNull
    @NotBlank
    private String option4;

    @Column
    @NotNull
    @NotBlank
    private String category;

    @Column
    @NotNull
    @NotBlank
    private String answer;


    public QuestionModel(){
    }

    public QuestionModel(Integer id, String question, String option1, String option2, String option3, String option4, String category, String answer) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.category = category;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
