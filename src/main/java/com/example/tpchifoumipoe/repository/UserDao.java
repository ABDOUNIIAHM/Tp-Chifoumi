package com.example.tpchifoumipoe.repository;

import com.example.tpchifoumipoe.entities.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IntUserDao{
    Connection conn = ConnectionManager.getConnection();

    @Override
    public void save(User user)  {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO users (name, Identifier, password) VALUES (? , ?, ?)");
            ps.setString(1,user.getName());
            ps.setString(2,user.getId());
            ps.setString(3,user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT users_id,name,identifier,password FROM users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                User user = new User(rs.getString("name"),rs.getString("identifier"), rs.getString("password"));
                user.setUserId(rs.getInt("users_id"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    public boolean findByDesignation(String mc){
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE identifier = ?");
            ps.setString(1,mc);
            ResultSet rs = ps.executeQuery();
            if(rs.next()==false){
                System.out.println("no matching id found, you can create account");
                return false;
            }else{
                System.out.println("id already taken, choose another one!");
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public User findById(Integer integer) {
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE users_id = ? ");
            ps.setInt(1,integer);
            ResultSet rs = ps.executeQuery();
            User user = new User(rs.getString("name"),rs.getString("identifier"), rs.getString("password"));
            user.setUserId(rs.getInt("users_id"));
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public User findByUsername(String username){
        User user=null;
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE identifier = ? ");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User(rs.getString("name"),rs.getString("identifier"), rs.getString("password"));
                user.setUserId(rs.getInt("users_id"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer integer) {
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE users_id = ?");
            ps.setInt(1,integer);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
