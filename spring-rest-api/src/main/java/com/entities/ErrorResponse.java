package com.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 *
 * @author s.tsourdos
 */
public class ErrorResponse {
    private String message;
    private String cause;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ")
    private Date timestamp;

    public ErrorResponse(String message, String cause) {
        this.message = message;
        this.cause = cause;
        this.timestamp = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
