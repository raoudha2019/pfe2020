package com.telnet.qcm.entities;

import java.io.Serializable;

public class Response implements Serializable {

    String label ;
    String code;
    String correct;

    public Response(String label,String code, String correct) {
        this.label = label;
        this.code = code;
        this.correct = correct;
    }

    public Response() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}
