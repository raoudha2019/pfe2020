package com.telnet.qcm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name="qcm")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Qcm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String desQuestion;
    private Integer level;
    private String requiredTime;
    private String status;
    private String option1;
    private String option2;
    private String option3;



    //bi-directional many-to-one association to Answer
    @JsonIgnore
    @OneToMany(mappedBy="qcm", cascade = CascadeType.REMOVE)
    private List<Answer> answers;

    //bi-directional many-to-one association to Subcategory
    @ManyToOne(fetch = FetchType.EAGER)
    private Domain domain;

    public Qcm(String desQuestion) {
        this.desQuestion = desQuestion;
    }

    public Qcm() {
        super();
    }

    public Qcm(String desQuestion, Integer level, String requiredTime, String status, String option1, String option2, String option3, List<Answer> answers, Domain domain) {
        this.desQuestion = desQuestion;
        this.level = level;
        this.requiredTime = requiredTime;
        this.status = status;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answers = answers;
        this.domain = domain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesQuestion() {
        return desQuestion;
    }

    public void setDesQuestion(String desQuestion) {
        this.desQuestion = desQuestion;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(String requiredTime) {
        this.requiredTime = requiredTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
   // @JsonIgnore

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

}
