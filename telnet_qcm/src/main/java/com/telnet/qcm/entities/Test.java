package com.telnet.qcm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Test")
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Long max_nb_questions;
    private String status;
    @JsonIgnore
    @OneToMany(mappedBy="test", cascade = CascadeType.REMOVE)
    private List<QcmJ> Qcmjs;

    public Test() {
    }

    public Test(String title, Long max_nb_questions, String status, List<QcmJ> qcmJs) {
        this.title = title;
        this.max_nb_questions = max_nb_questions;
        this.status = status;
        Qcmjs = qcmJs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getMax_nb_questions() {
        return max_nb_questions;
    }

    public void setMax_nb_questions(Long max_nb_questions) {
        this.max_nb_questions = max_nb_questions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<QcmJ> getQcmjs() {
        return Qcmjs;
    }

    public void setQcmjs(List<QcmJ> qcmjs) {
        Qcmjs = qcmjs;
    }
}
