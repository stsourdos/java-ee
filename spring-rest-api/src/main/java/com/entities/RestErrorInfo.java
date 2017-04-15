package com.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestErrorInfo {

    private String detail;
    private String message;

    public RestErrorInfo(Exception ex, String detail) {
        this.message = ex.getLocalizedMessage();
        this.detail = detail;
    }

    public RestErrorInfo() {
    }

    public String getDetail() {
        return detail;
    }

    @XmlElement
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @XmlElement
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
