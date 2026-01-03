package com.siva.RESTAPI.repository;

import com.siva.RESTAPI.model.CricketPlayer;
import com.siva.RESTAPI.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CricketPlayerRepository {

    public List<CricketPlayer> findAll() {
        List<CricketPlayer> list = new ArrayList<>();
        String sql = "SELECT * FROM cricket_player";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CricketPlayer p = new CricketPlayer();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setTeam(rs.getString("team"));
                p.setRole(rs.getString("role"));
                p.setRuns(rs.getInt("runs"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    /**
     * Fetch a single cricket player by ID
     */
    public CricketPlayer findById(int id) {

        // SQL query to fetch one record
        String sql = "SELECT * FROM cricket_player WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Set ID value in query
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                // If record exists
                if (rs.next()) {

                    CricketPlayer player = new CricketPlayer();
                    player.setId(rs.getInt("id"));
                    player.setName(rs.getString("name"));
                    player.setTeam(rs.getString("team"));
                    player.setRole(rs.getString("role"));
                    player.setRuns(rs.getInt("runs"));

                    return player;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return null if no record found
        return null;
    }

    
    /**
     * Fetches cricket players whose name matches the given string.
     * Uses SQL LIKE operator for partial matching.
     *
     * @param name the string to search in player names
     * @return list of matching CricketPlayer objects
     */
    public List<CricketPlayer> getPlayersByName(String name) {

        // List to store fetched players
        List<CricketPlayer> players = new ArrayList<>();

        // SQL query to search players by name (partial match)
        String sql = "SELECT * FROM cricket_player WHERE name LIKE ?";

        // Try-with-resources ensures DB resources are closed automatically
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Bind query parameter with wildcard for partial search
            ps.setString(1, "%" + name + "%");

            // Execute query
            ResultSet rs = ps.executeQuery();

            // Iterate through result set and map rows to objects
            while (rs.next()) {

                CricketPlayer player = new CricketPlayer();
                player.setId(rs.getInt("id"));
                player.setName(rs.getString("name"));
                player.setTeam(rs.getString("team"));
                player.setRole(rs.getString("role"));
                player.setRuns(rs.getInt("runs"));

                players.add(player);
            }

        } catch (Exception e) {
            // Log exception (replace with logger in real projects)
            e.printStackTrace();
        }

        return players;
    }

    
    
    /**
     * Checks whether a player already exists based on name and team.
     *
     * @param name player's name
     * @param team player's team
     * @return true if player exists, false otherwise
     */
    public boolean playerExists(String name, String team) {

        String sql =
                "SELECT COUNT(*) FROM cricket_player WHERE name = ? AND team = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, team);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Checks whether a player exists by id.
     *
     * @param id player id
     * @return true if exists, false otherwise
     */
    public boolean playerExistsById(int id) {

        String sql = "SELECT COUNT(*) FROM cricket_player WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    /**
     * Checks whether another player (excluding given id)
     * exists with the same name and team.
     *
     * @param name player name
     * @param team player team
     * @param id   current player id
     * @return true if duplicate exists, false otherwise
     */
    public boolean playerExistsForOtherId(String name, String team, int id) {

        String sql =
                "SELECT COUNT(*) FROM cricket_player " +
                "WHERE name = ? AND team = ? AND id <> ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, team);
            ps.setInt(3, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Fetches a player by id.
     *
     * @param id player id
     * @return CricketPlayer if found, null otherwise
     */
    public CricketPlayer getPlayerById(int id) {

        String sql = "SELECT * FROM cricket_player WHERE id = ?";
        CricketPlayer player = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                player = new CricketPlayer();
                player.setId(rs.getInt("id"));
                player.setName(rs.getString("name"));
                player.setTeam(rs.getString("team"));
                player.setRole(rs.getString("role"));
                player.setRuns(rs.getInt("runs"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return player;
    }


    
    /**
     * Updates an existing player using full replacement (PUT semantics).
     *
     * @param id player id
     * @param player updated player data
     * @return true if update succeeded
     */
    public boolean updatePlayer(int id, CricketPlayer player) {

        String sql =
                "UPDATE cricket_player " +
                "SET name = ?, team = ?, role = ?, runs = ? " +
                "WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, player.getName());
            ps.setString(2, player.getTeam());
            ps.setString(3, player.getRole());
            ps.setInt(4, player.getRuns());
            ps.setInt(5, id);

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public void save(CricketPlayer p) {

        String sql = "INSERT INTO cricket_player(name, team, role, runs) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getTeam());
            ps.setString(3, p.getRole());
            ps.setInt(4, p.getRuns());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getInt(1));   // 🎯 attach DB id back to object
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void saveAll(List<CricketPlayer> players) {

        String sql = "INSERT INTO cricket_player(name, team, role, runs) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            for (CricketPlayer p : players) {
                ps.setString(1, p.getName());
                ps.setString(2, p.getTeam());
                ps.setString(3, p.getRole());
                ps.setInt(4, p.getRuns());
                ps.addBatch();
            }

            ps.executeBatch();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                int index = 0;
                while (rs.next() && index < players.size()) {
                    players.get(index).setId(rs.getInt(1));
                    index++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
