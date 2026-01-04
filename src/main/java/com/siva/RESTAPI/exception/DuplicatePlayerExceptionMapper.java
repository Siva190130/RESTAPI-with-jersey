package com.siva.RESTAPI.exception;

import com.siva.RESTAPI.model.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Maps DuplicatePlayerException to HTTP 409 Conflict.
 */
@Provider
public class DuplicatePlayerExceptionMapper
        implements ExceptionMapper<DuplicatePlayerException> {

    @Override
    public Response toResponse(DuplicatePlayerException exception) {

        ErrorResponse errorResponse =
                new ErrorResponse(
                        Response.Status.CONFLICT.getStatusCode(),
                        exception.getMessage()
                );

        return Response.status(Response.Status.CONFLICT)
                       .entity(errorResponse)
                       .build();
    }
}
