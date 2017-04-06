package com.tsourdos.javaee7restfulapi.configuration;

import javax.json.Json;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author s.tsourdos
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(Json.createObjectBuilder()
                        .add("message", "No such endpoint handler found")
                        .add("exceptionMessage", e.getMessage())
                        .build())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
