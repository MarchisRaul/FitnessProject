package com.example.demo;

import java.util.List;

public class UserBLL {
    private UserDAO userDAO;

    public UserBLL() {
        userDAO = new UserDAO();
    }

    public List<User> findAllClients() {
        List<User> usersList = userDAO.findAll();
        return usersList;
    }

    public void insertClient(User user) {
        userDAO.insert(user);
    }
}
