package com.siva.RESTAPI.service;

/**
 * ------------------------------------------------------------
 * CricketPlayerService
 * ------------------------------------------------------------
 *
 * Service layer containing ALL business logic for Cricket APIs.
 *
 * Author      : Shiv (Associate Software Engineer)
 * Project     : RESTAPI (JAX-RS / Jersey)
 *
 * Responsibilities:
 * - Perform validations
 * - Enforce business rules
 * - Throw domain-specific exceptions
 * - Orchestrate repository operations
 *
 * Does NOT:
 * - Handle HTTP concerns
 * - Access JDBC directly
 *
 * ------------------------------------------------------------
 */


import com.siva.RESTAPI.exception.DuplicatePlayerException;
import com.siva.RESTAPI.exception.PlayerNotFoundException;
import com.siva.RESTAPI.exception.ValidationException;
import com.siva.RESTAPI.model.ApiResponse;
import com.siva.RESTAPI.model.CricketPlayer;
import com.siva.RESTAPI.repository.CricketPlayersRepository;
import com.siva.RESTAPI.repository.JdbcCricketPlayerRepository;

import java.util.ArrayList;
import java.util.List;

public class CricketPlayerService {

    private final CricketPlayersRepository repository =
            new JdbcCricketPlayerRepository();

    /* ---------------- READ ---------------- */

    public List<CricketPlayer> getAllPlayers() {
        return repository.findAll();
    }

    public CricketPlayer getPlayerById(int id) {
        CricketPlayer player = repository.findById(id);
        if (player == null) {
            throw new PlayerNotFoundException(id);
        }
        return player;
    }

    public List<CricketPlayer> getPlayersByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException(
                    "Query parameter 'name' must not be empty"
            );
        }
        return repository.getPlayersByName(name);
    }

    /* ---------------- CREATE ---------------- */

    public CricketPlayer createPlayer(CricketPlayer player) {

        validatePlayer(player);

        if (repository.playerExists(player.getName(), player.getTeam())) {
            throw new DuplicatePlayerException(
                    player.getName(),
                    player.getTeam()
            );
        }

        repository.save(player);
        return player;
    }
    
    /**
     * Bulk insert business logic.
     * Skips invalid and duplicate records.
     */
    public ApiResponse<?> addPlayersInBulk(List<CricketPlayer> players) {

        if (players == null || players.isEmpty()) {
            throw new ValidationException("Players list must not be empty");
        }

        List<CricketPlayer> validPlayers = new ArrayList<>();
        List<CricketPlayer> skippedPlayers = new ArrayList<>();

        for (CricketPlayer player : players) {

            try {
                // Reuse single authoritative validation logic
                validatePlayer(player);

                // Duplicate check
                if (repository.playerExists(player.getName(), player.getTeam())) {
                    skippedPlayers.add(player);
                    continue;
                }

                validPlayers.add(player);

            } catch (ValidationException ex) {
                // In bulk mode, validation failure means "skip", not "fail"
                skippedPlayers.add(player);
            }
        }

        if (!validPlayers.isEmpty()) {
            repository.saveAll(validPlayers);
        }

        return new ApiResponse<>(
                201,
                "Bulk insert completed. Inserted: "
                        + validPlayers.size()
                        + ", Skipped: "
                        + skippedPlayers.size(),
                validPlayers
        );
    }

    /* ---------------- UPDATE (PUT) ---------------- */

    public CricketPlayer updatePlayer(int id, CricketPlayer player) {

        validatePlayer(player);

        if (!repository.playerExistsById(id)) {
            throw new PlayerNotFoundException(id);
        }

        if (repository.playerExistsForOtherId(
                player.getName(),
                player.getTeam(),
                id)) {

            throw new DuplicatePlayerException(
                    player.getName(),
                    player.getTeam()
            );
        }

        repository.updatePlayer(id, player);
        return player;
    }

    /* ---------------- UPDATE (PATCH) ---------------- */

    public CricketPlayer patchPlayer(int id, CricketPlayer incoming) {

        CricketPlayer existing = repository.getPlayerById(id);
        if (existing == null) {
            throw new PlayerNotFoundException(id);
        }

        if (incoming.getName() != null) {
            existing.setName(incoming.getName());
        }
        if (incoming.getTeam() != null) {
            existing.setTeam(incoming.getTeam());
        }
        if (incoming.getRole() != null) {
            existing.setRole(incoming.getRole());
        }
        if (incoming.getRuns() != 0) {
            existing.setRuns(incoming.getRuns());
        }

        repository.updatePlayer(id, existing);
        return existing;
    }

    /* ---------------- DELETE ---------------- */

    public void deletePlayer(int id) {
        if (!repository.playerExistsById(id)) {
            throw new PlayerNotFoundException(id);
        }
        repository.deletePlayerById(id);
    }

    /* ---------------- COMMON VALIDATION ---------------- */

    private void validatePlayer(CricketPlayer player) {

        if (player == null ||
            player.getName() == null || player.getName().trim().isEmpty() ||
            player.getTeam() == null || player.getTeam().trim().isEmpty() ||
            player.getRole() == null || player.getRole().trim().isEmpty()) {

            throw new ValidationException(
                    "Invalid player data. Name, team, and role are required."
            );
        }
    }
   
}
