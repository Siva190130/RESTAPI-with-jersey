package com.siva.RESTAPI.exception;

/**
 * Thrown when a duplicate player (name + team) is detected.
 */
public class DuplicatePlayerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DuplicatePlayerException(String name, String team) {
        super("Player with name '" + name + "' already exists for team '" + team + "'");
    }
}
