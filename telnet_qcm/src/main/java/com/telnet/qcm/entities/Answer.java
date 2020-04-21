package com.telnet.qcm.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Answer")

public class Answer implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String option1;
    private String option2;
    private String option3;

    //bi-directional many-to-one association to Question
    @ManyToOne
    private Qcm qcm;

    public Answer() {
        super();

    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Answer( Long id,String option1, String option2, String option3, Qcm qcm) {
        this.id = id;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.qcm = qcm;
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

    public Qcm getQcm() {
        return qcm;
    }

    public void setQcm(Qcm qcm) {
        this.qcm = qcm;
    }
}
