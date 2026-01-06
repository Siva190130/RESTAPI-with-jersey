package com.siva.RESTAPI.repository;

/**
 * ------------------------------------------------------------
 * CricketPlayersRepository
 * ------------------------------------------------------------
 *
 * Repository contract defining persistence operations
 * for CricketPlayer entities.
 *
 * Author      : Shiv (Associate Software Engineer)
 * Project     : RESTAPI
 *
 * Notes:
 * - This is a CONTRACT only
 * - No business logic
 * - No SQL
 * - Implemented by JDBC / JPA repositories
 *
 * ------------------------------------------------------------
 */


import com.siva.RESTAPI.model.CricketPlayer;
import java.util.List;

public interface CricketPlayersRepository {

    List<CricketPlayer> findAll();

    CricketPlayer findById(int id);
    
    CricketPlayer getPlayerById(int id);

    List<CricketPlayer> getPlayersByName(String name);

    boolean playerExists(String name, String team);

    boolean playerExistsById(int id);

    boolean playerExistsForOtherId(String name, String team, int id);

    void save(CricketPlayer player);

    void saveAll(List<CricketPlayer> players);

    boolean updatePlayer(int id, CricketPlayer player);

    boolean deletePlayerById(int id);
}
