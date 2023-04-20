package com.example.tpchifoumipoe.service;


import com.example.tpchifoumipoe.entities.User;
import com.example.tpchifoumipoe.repository.IntUserDao;

import java.sql.SQLException;

public class UserService {
    private IntUserDao userDao;

    public UserService(IntUserDao userDao) {
        this.userDao = userDao;
    }
    public boolean validInscription(String id) throws SQLException {

        if (userDao.findByDesignation(id) == false) {
            System.out.println("inscription OK");
            return true;
        } else {
            System.out.println("Sorry id deja existant, try again");
            return false;

        }
    }
    public boolean validAuthentification(String username, String password){
        User user = userDao.findByUsername(username);
        if(userDao.findByUsername(username) == null){
            System.out.println("you have an error in your id or password !");
            return false;
        }else{
            if(user.getPassword().equals(password)){
                System.out.println("valid authentification");
                return true;
            }else{
                return false;
            }
        }
    }
}
