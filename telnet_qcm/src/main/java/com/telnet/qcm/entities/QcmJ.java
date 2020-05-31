package com.telnet.qcm.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;


@TypeDefs({
       // @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Entity(name = "qcmJ")
@Table(name = "qcmJ")


public class QcmJ implements Serializable {


    @Id
    @GeneratedValue
    @Column(name = "qcm_id")
    private Long id;

    @Column(name = "subDomain")
    private String subDomain;

    @Column(name = "title")
    private String title;

        @Type(type = "jsonb")
        @Column(columnDefinition = "jsonb")
        private QuestionBody questionBody;
       @Transient
        private QuestionBody questionBody1;
       @Column(name = "question")
       private String question;

    @ManyToOne(fetch = FetchType.EAGER)
    private Test test;






    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    //bi-directional many-to-one association to Subcategory
    @ManyToOne(fetch = FetchType.EAGER)
    private Domain domain ;

    //bi-directional many-to-one association to Subcategory
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;


    public QcmJ() {

    }

    public QcmJ(Long id,String title, QuestionBody questionBody, String question, String subDomain,Test test ,Domain domain, User user) {
        this.id =id;
        this.subDomain = subDomain;
        this.title = title;
        this.questionBody = questionBody;
        this.question = question;
        this.test = test;
        this.domain = domain;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubDomain() {
        return subDomain;
    }

    public void setSubDomain(String subDomain) {
        this.subDomain = subDomain;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public QuestionBody getQuestionBody1() {
        return questionBody1;
    }

    public void setQuestionBody1(QuestionBody questionBody1) {
        this.questionBody1 = questionBody1;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}






