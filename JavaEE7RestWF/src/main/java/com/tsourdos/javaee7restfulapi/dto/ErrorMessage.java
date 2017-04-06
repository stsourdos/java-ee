package com.tsourdos.javaee7restfulapi.dto;

/**
 *
 * @author s.tsourdos
 */
public class ErrorMessage {
    private final String message;
    private final String parentMessage;
    private final int code;

    public ErrorMessage(String message, int code, String parentMessage) {
        this.message = message;
        this.parentMessage = parentMessage;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getParentMessage() {
        return parentMessage;
    }
}
