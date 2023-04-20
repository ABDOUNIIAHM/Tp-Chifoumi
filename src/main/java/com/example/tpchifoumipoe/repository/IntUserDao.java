package com.example.tpchifoumipoe.repository;

import com.example.tpchifoumipoe.entities.User;

public interface IntUserDao extends GenericDao<User,Integer>{
    public boolean findByDesignation(String mc);
    User findByUsername(String username);
}
