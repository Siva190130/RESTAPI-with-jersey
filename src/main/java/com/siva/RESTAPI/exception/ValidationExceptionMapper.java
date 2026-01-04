package com.siva.RESTAPI.exception;

import com.siva.RESTAPI.model.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Maps ValidationException to HTTP 400 response.
 */
@Provider
public class ValidationExceptionMapper
        implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException exception) {

        ErrorResponse errorResponse =
                new ErrorResponse(
                        Response.Status.BAD_REQUEST.getStatusCode(),
                        exception.getMessage()
                );

        return Response.status(Response.Status.BAD_REQUEST)
                       .entity(errorResponse)
                       .build();
    }
}
