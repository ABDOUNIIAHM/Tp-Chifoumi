package com.example.tpchifoumipoe.entities;

public class User {
    private int userId;
    private String name;
    private String id;
    private String password;

    public User(String name,String id, String password) {
        this.name = name;
        this.password = password;
        this.id=id;
    }
    public User(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
