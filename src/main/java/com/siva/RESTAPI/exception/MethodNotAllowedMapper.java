package com.siva.RESTAPI.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.siva.RESTAPI.model.ErrorResponse;

@Provider
public class MethodNotAllowedMapper
        implements ExceptionMapper<javax.ws.rs.NotAllowedException> {

    @Override
    public Response toResponse(javax.ws.rs.NotAllowedException ex) {

        ErrorResponse error =
                new ErrorResponse(
                        Response.Status.METHOD_NOT_ALLOWED.getStatusCode(),
                        "HTTP method not allowed for this endpoint"
                );

        return Response.status(Response.Status.METHOD_NOT_ALLOWED)
                       .entity(error)
                       .build();
    }
}
