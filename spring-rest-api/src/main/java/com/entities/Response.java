package com.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

    private int rowsAffected;
    private String result;

    public int getRowsAffected() {
        return rowsAffected;
    }

    @XmlElement
    public void setRowsAffected(int rowsAffected) {
        this.rowsAffected = rowsAffected;
    }

    public String getResult() {
        return result;
    }

    @XmlElement
    public void setResult(String result) {
        this.result = result;
    }
}
