package com.telnet.qcm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

@Table(name="Domain")
public class Domain implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    @OneToMany(mappedBy="domain", cascade = CascadeType.REMOVE)
    private List<QcmJ> qcmJ ;


    public Domain() {
        super();
    }

    public Domain(Long id,String name, List<QcmJ>qcmJ) {
        this.id = id;
        this.name = name;

        this.qcmJ = qcmJ;
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


    public List<QcmJ> getQcmJ() {
        return qcmJ;
    }

    public void setQcmJ(List<QcmJ> qcmJ) {
        this.qcmJ = qcmJ;
    }

}
