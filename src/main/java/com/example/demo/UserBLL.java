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

    /**
     * se va sterge clientul primit ca parametru din tabela Client
     *
     * @param myClient reprezinta un client
     */
    public void deleteClient(User myClient) {
        userDAO.delete(myClient);
    }

    /**
     * metoda va face update pe clientul din tabel care are id_client egal cu id-ul
     * primit ca parametru
     *
     * @param myClient reprezinta un client din tabela Client
     * @param id       reprezinta un id
     */
    public void updateClient(User myClient, int id) {
        userDAO.update(myClient, id);
    }

    /**
     *
     * @param id reprezinta un id
     * @return clientul din tabela Client care are id_client egal cu id-ul primit ca
     *         parametru
     */
    public User findById(int id) {
        return userDAO.findById(id);
    }
}
