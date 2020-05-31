package com.telnet.qcm.entities;

import java.io.Serializable;

public class Qcm11 implements Serializable {

    private Long id;
    private String subDomain;
    private String title;
    private QuestionBody questionBody;
    private Domain domain;
    public Qcm11() { }
    public Qcm11(Long id,String subDomain ,String title, QuestionBody questionBody , Domain domain) {
        this.id = id;
        this.subDomain = subDomain;
        this.title = title;
        this.questionBody = questionBody;
        this.domain = domain;
    }


    public Long getId() {
        return id; }
    public void setId(Long id) {
        this.id = id; }

    public String getSubDomain() {
        return subDomain;
    }

    public void setSubDomain(String subDomain) {
        this.subDomain = subDomain;
    }

    public String getTitle() {
        return title; }
    public void setTitle(String title) {
        this.title = title;
    }
    public QuestionBody getQuestionBody() {
        return questionBody;
    }
    public void setQuestionBody(QuestionBody questionBody) {
        this.questionBody = questionBody;
    }

        public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}
