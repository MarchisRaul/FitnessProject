package com.example.demo;

public class Trainer {
    private int id_trainer_pk;
    private boolean university_diploma;
    private int training_price;

    public Trainer(int id_trainer_pk, boolean university_diploma, int training_price) {
        this.id_trainer_pk = id_trainer_pk;
        this.university_diploma = university_diploma;
        this.training_price = training_price;
    }

    public Trainer() {

    }

    public int getId_trainer_pk() {
        return id_trainer_pk;
    }

    public void setId_trainer_pk(int id_trainer_pk) {
        this.id_trainer_pk = id_trainer_pk;
    }

    public boolean isUniversity_diploma() {
        return university_diploma;
    }

    public void setUniversity_diploma(boolean university_diploma) {
        this.university_diploma = university_diploma;
    }

    public int getTraining_price() {
        return training_price;
    }

    public void setTraining_price(int training_price) {
        this.training_price = training_price;
    }
}
