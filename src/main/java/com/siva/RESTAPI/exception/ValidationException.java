package com.siva.RESTAPI.exception;

/**
 * Thrown when request validation fails (400 Bad Request).
 */
public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValidationException(String message) {
        super(message);
    }
}
