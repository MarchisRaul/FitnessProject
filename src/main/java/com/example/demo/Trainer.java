package com.example.demo;

public class Trainer {
    private int id_trainer_pk;
    private String name;
    private int university_diploma;
    private int training_price;

    public Trainer(int id_trainer_pk, String name, int university_diploma, int training_price) {
        this.name = name;
        this.id_trainer_pk = id_trainer_pk;
        this.university_diploma = university_diploma;
        this.training_price = training_price;
    }

    public Trainer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_trainer_pk() {
        return id_trainer_pk;
    }

    public void setId_trainer_pk(int id_trainer_pk) {
        this.id_trainer_pk = id_trainer_pk;
    }

    public int getUniversity_diploma() {
        return university_diploma;
    }

    public void setUniversity_diploma(int university_diploma) {
        this.university_diploma = university_diploma;
    }

    public int getTraining_price() {
        return training_price;
    }

    public void setTraining_price(int training_price) {
        this.training_price = training_price;
    }
}
