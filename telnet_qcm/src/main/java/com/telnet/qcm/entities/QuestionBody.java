package com.telnet.qcm.entities;


import java.io.Serializable;
import java.util.List;

public class QuestionBody implements Serializable {

    Long id;
    String question;
    List<Response> responses;

    public QuestionBody() {
    }

    public QuestionBody(Long id, String question, List<Response> responses) {
        this.id = id;
        this.question = question;
        this.responses = responses;
    }

    public QuestionBody(String question, List<Response> responses) {
        this.question = question;
        this.responses = responses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }


}
