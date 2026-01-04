package com.siva.RESTAPI.exception;

import com.siva.RESTAPI.model.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Maps PlayerNotFoundException to HTTP 404 response.
 */
@Provider
public class PlayerNotFoundExceptionMapper
        implements ExceptionMapper<PlayerNotFoundException> {

    @Override
    public Response toResponse(PlayerNotFoundException exception) {

        ErrorResponse errorResponse =
                new ErrorResponse(
                        Response.Status.NOT_FOUND.getStatusCode(),
                        exception.getMessage()
                );

        return Response.status(Response.Status.NOT_FOUND)
                       .entity(errorResponse)
                       .build();
    }
}
