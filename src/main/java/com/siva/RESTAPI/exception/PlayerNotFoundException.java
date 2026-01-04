package com.siva.RESTAPI.exception;

/**
 * Thrown when a cricket player is not found by id.
 */
public class PlayerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final int playerId;

    public PlayerNotFoundException(int playerId) {
        super("Player not found with id: " + playerId);
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }
}
