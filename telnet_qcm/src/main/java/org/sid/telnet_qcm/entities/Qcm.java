package org.sid.telnet_qcm.entities;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
    @Entity
    @Table(name = "qcm")
    public class Qcm {

        private long id;
        private String domaine;
        private String question;
        private String temps;
        private long dgree;



        public Qcm() {
        }

        public Qcm(long id) {
            this.id = id;
        }

        public Qcm(long id, String domaine, String question, String temps, Long dgree) {
            this.id = id;
            this.domaine = domaine;
            this.question = question;
            this.temps = temps;
            this.dgree = dgree;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }

        @Column(name = "domaine", nullable = false)
        public String getDomaine() {
            return domaine;
        }
        public void setDomaine(String domaine) {
            this.domaine = domaine;
        }
        @Column(name = "question", nullable = false)
        public String getQuestion() {
            return question;
        }
        public void setQuestion(String question) {
            this.question = question;
        }
        @Column(name = "temps", nullable = false)
        public String getTemps() {
            return temps;
        }
        public void setTemps(String temps) {
            this.temps = temps;
        }
        @Column(name = "dgree", nullable = false)
        public long getDgree() {
            return dgree;
        }
        public void setDgree(long dgree) {
            this.dgree = dgree;
        }

        @OneToMany
                (targetEntity= An.class,cascade = CascadeType.ALL,
                fetch = FetchType.LAZY, orphanRemoval = true)
        private List<An> an = new ArrayList<>();




        @Override
        public String toString() {
            return "qcm{" +
                    "id=" + id +
                    ", domaine='" + domaine + '\'' +
                    ", question='" + question + '\'' +
                    ", temps='" + temps + '\'' +
                    ", dgree=" + dgree +
                    '}';
        }
    }
