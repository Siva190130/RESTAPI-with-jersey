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
