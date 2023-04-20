package com.example.tpchifoumipoe.repository;

import com.example.tpchifoumipoe.entities.Game;
import com.example.tpchifoumipoe.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDao implements IntGameDao{
    Connection conn = ConnectionManager.getConnection();


    @Override
    public void save(Game game) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO games (Server_choice, User_choice, Winner, isDraw, round_num) VALUES (? , ?, ?, ?, ?)");
            ps.setString(1,game.getServerChoice());
            ps.setString(2,game.getUserChoice());
            ps.setString(3,game.getWinner());
            ps.setBoolean(4,game.getIsDraw());
            ps.setInt(5,game.getRound());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Game> findAll() {
        List<Game> games = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM games");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Game game = new Game(rs.getString("Server_choice"),rs.getString("User_choice"), rs.getString("Winner"), rs.getInt("round_num"));
                game.setGameId(rs.getInt("game_id"));
                game.setDraw(rs.getBoolean("isDraw"));
                games.add(game);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return games;
    }

    @Override
    public void update(Game entity) {

    }

    @Override
    public Game findById(Integer integer) {
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM games WHERE game_id = ? ");
            ps.setInt(1,integer);
            ResultSet rs = ps.executeQuery();
            Game game = new Game(rs.getString("Server_choice"),rs.getString("User_choice"), rs.getString("Winner"), rs.getInt("round-num"));
            game.setGameId(rs.getInt("game_id"));
            game.setDraw(rs.getBoolean("isDraw"));
            return game;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteById(Integer integer) {

    }
}
