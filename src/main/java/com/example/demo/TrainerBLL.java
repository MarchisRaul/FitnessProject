package com.example.demo;

import java.util.List;

public class TrainerBLL {
    private TrainerDAO trainerDAO;

    public TrainerBLL() {
        trainerDAO = new TrainerDAO();
    }

    public List<Trainer> findAllTrainers() {
        List<Trainer> trainersList = trainerDAO.findAll();
        return trainersList;
    }

    public void insertTrainer(Trainer trainer) {
        trainerDAO.insert(trainer);
    }


    /**
     * se va sterge clientul primit ca parametru din tabela Client
     *
     * @param myTrainer reprezinta un client
     */
    public void deleteTrainer(Trainer myTrainer) {
        trainerDAO.delete(myTrainer);
    }

    /**
     * metoda va face update pe clientul din tabel care are id_client egal cu id-ul
     * primit ca parametru
     *
     * @param myTrainer reprezinta un client din tabela Client
     * @param id       reprezinta un id
     */
    public void updateTrainer(Trainer myTrainer, int id) {
        trainerDAO.update(myTrainer, id);
    }

    /**
     *
     * @param id reprezinta un id
     * @return clientul din tabela Client care are id_client egal cu id-ul primit ca
     *         parametru
     */
    public Trainer findById(int id) {
        return trainerDAO.findById(id);
    }
}
