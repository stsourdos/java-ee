package com.tsourdos.javaee7restfulapi.exceptions;

import java.io.Serializable;
import javax.ws.rs.core.Response;

/**
 *
 * @author s.tsourdos
 */
public class WebApplicationException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;
    private final Response.Status status;
    private final int code;

    public WebApplicationException(String msg, Response.Status status, int code, Throwable th) {
        super(msg, th);
        this.status = status;
        this.code = code;
    }

    public Response.Status getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }
}
