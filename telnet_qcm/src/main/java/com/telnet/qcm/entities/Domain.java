package com.telnet.qcm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Table(name="Domain")
public class Domain implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    //bi-directional many-to-one association to Question
    @JsonIgnore
    @OneToMany(mappedBy="domain", cascade = CascadeType.REMOVE)
    private List<Qcm> qcm;

    public Domain() {
        super();
    }

    public Domain(Long id,String name, List<Qcm> qcm) {
        this.id = id;
        this.name = name;
        this.qcm = qcm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Qcm> getQcm() {
        return qcm;
    }

    public void setQcm(List<Qcm> qcm) {
        this.qcm = qcm;
    }
}
