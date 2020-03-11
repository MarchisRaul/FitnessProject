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
}
