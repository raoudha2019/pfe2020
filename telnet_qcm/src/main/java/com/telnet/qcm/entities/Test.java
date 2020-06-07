package com.telnet.qcm.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

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
    private Long time_limite;

    /* @JsonIgnore
    @OneToMany(mappedBy="test", cascade = CascadeType.REMOVE)
    private List<QcmJ> Qcmjs;
*/
    @ManyToMany
    @JoinTable(
            name = "tests_QcmJs",

            joinColumns = @JoinColumn (name = "test_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "qcmJ_id", referencedColumnName = "qcm_id"))

    private Collection<QcmJ> qcmJs;

    public Test() {
    }

    public Test(String title, Long max_nb_questions,Long time_limite ,String status, Collection <QcmJ> qcmJs) {
        this.title = title;
        this.max_nb_questions = max_nb_questions;
        this.time_limite=time_limite;
        this.status = status;
        this.qcmJs = qcmJs;
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

    public Long getTime_limite() {
        return time_limite;
    }

    public void setTime_limite(Long time_limite) {
        this.time_limite = time_limite;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<QcmJ> getQcmJs() {
        return qcmJs;
    }

    public void setQcmJs(Collection<QcmJ> qcmJs) {
        this.qcmJs = qcmJs;
    }
}

