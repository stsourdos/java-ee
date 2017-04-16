package com.configuration;

import com.entities.ErrorResponse;
import com.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author s.tsourdos
 */
@ControllerAdvice
public class ErrorAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    protected ErrorResponse handleNotFoundException(RuntimeException ex, WebRequest request) {
        return new ErrorResponse(ex.getMessage(), ex.getClass().getSimpleName());
    }
}
