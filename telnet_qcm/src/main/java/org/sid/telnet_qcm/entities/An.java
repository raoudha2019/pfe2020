package org.sid.telnet_qcm.entities;

import javax.persistence.*;

@Entity
@Table(name = "an")
public class An {

        private long id;
        private String option;
        private Boolean stat;


    public An(long id) {
        this.id = id;
    }

    public An() {
    }

    public An(long id, String option, Boolean stat) {
        this.id = id;
        this.option = option;
        this.stat = stat;
    }


    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
    @Column(name = "option", nullable = false)
    public String getOption() {
        return option;
    }
    public void setOption(String option) {
        this.option = option;
    }
    @Column(name = "stat", nullable = false)
    public Boolean getStat() {
        return stat;
    }
    @Column(name = "stat", nullable = false)
    public void setStat(Boolean stat) {
        this.stat = stat;
    }
    @Column(name = "id_qcm", nullable = false)

    @Override
    public String toString() {
        return "An{" +
                "id=" + id +
                ", option='" + option + '\'' +
                ", stat=" + stat +
                '}';
    }
}

