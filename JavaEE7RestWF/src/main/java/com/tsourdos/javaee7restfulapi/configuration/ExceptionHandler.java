package com.tsourdos.javaee7restfulapi.configuration;

import com.tsourdos.javaee7restfulapi.dto.ErrorMessage;
import com.tsourdos.javaee7restfulapi.exceptions.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author s.tsourdos
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<WebApplicationException> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public Response toResponse(WebApplicationException exception) {
        LOGGER.error("returning exception");
        return Response.status(exception.getStatus())
                .entity(new ErrorMessage(exception.getMessage(), exception.getCode(), exception.getCause().getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
