package com.siva.RESTAPI.repository;

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
