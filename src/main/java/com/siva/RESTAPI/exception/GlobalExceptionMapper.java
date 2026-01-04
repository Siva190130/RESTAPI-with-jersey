package com.siva.RESTAPI.exception;

import com.siva.RESTAPI.model.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Handles all uncaught RuntimeExceptions.
 */
@Provider
public class GlobalExceptionMapper
        implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException exception) {

        ErrorResponse errorResponse =
                new ErrorResponse(
                        Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                        "Internal server error. Please contact support."
                );

        // In real projects, log exception here
        exception.printStackTrace();

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity(errorResponse)
                       .build();
    }
}
