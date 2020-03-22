package com.example.demo;

import java.util.Iterator;
import java.util.List;

public class UserBLL {
    private UserDAO userDAO;

    public UserBLL(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * @return all the users from the User table
     */
    public List<User> findAllClients() {
        List<User> usersList = userDAO.findAll();
        return usersList;
    }

    /**
     * Inserts a certain user into User table
     * @param user = the user that will be inserted
     */
    public void insertClient(User user) {
        userDAO.insert(user);
    }

    /**
     * Deletes a certain user from User table
     * @param user = the user that will be deleted
     */
    public void deleteClient(User user) {
        userDAO.delete(user);
    }

    /**
     * Updates a certain user from the table which has the id column value equal to the id received as a parameter
     * @param myUser = the new user which will substitute the old user after the update
     * @param id = the id received as a parameter
     */
    public void updateClient(User myUser, int id) {
        userDAO.update(myUser, id);
    }

    /**
     * @param id = the id received as a parameter
     * @return the respective user from the User table for which the id column is equal to the id received as a parameter
     */
    public User findById(int id) {
        return userDAO.findById(id);
    }

    /**
     * @return the value of the greatest id column from the User table
     */
    public int findBiggestUserId() {
        int maxId = 0;
        List<User> myList = userDAO.findAll();
        Iterator<User> myIt = myList.iterator();
        while (myIt.hasNext()) {
            User user = myIt.next();
            if (user.getId_user() > maxId)
                maxId = user.getId_user();
        }

        return maxId;
    }
}
